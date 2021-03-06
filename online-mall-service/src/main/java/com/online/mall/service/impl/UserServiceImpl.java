package com.online.mall.service.impl;

import com.mgcele.framework.springmvc.exception.BaseRestExceptionType;
import com.mgcele.framework.springmvc.exception.CommonRestException;
import com.mgcele.framework.springmvc.exception.UserNotExistedException;
import com.online.mall.enums.UserLoginNameType;
import com.online.mall.model.User;
import com.online.mall.model.UserLoginName;
import com.online.mall.repository.UserLoginNameRepository;
import com.online.mall.repository.UserRepository;
import com.online.mall.service.UserService;
import com.online.mall.service.VerificationCodeService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author mgcele
 * @since 1.0.0
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    
    @Resource(name = "verificationCodeService")
    private VerificationCodeService verificationCodeService;
    
    @Resource(name = "userRepository")
    private UserRepository userRepository;
    
    @Resource(name = "userLoginNameRepository")
    private UserLoginNameRepository userLoginNameRepository;
    
    @Override
    public User getUser(Long userId) throws CommonRestException {
        User user = userRepository.findOne(userId);
        if (user == null) {
            throw new UserNotExistedException();
        }
        return user;
    }
    
    @Override
    public User getUser(UserLoginNameType userLoginNameType, String loginName) throws CommonRestException {
        UserLoginName userLoginName = userLoginNameRepository.findUserLoginNameByUserLoginNameTypeAndLoginName(userLoginNameType, loginName);
        if (userLoginName == null) {
            throw new UserNotExistedException();
        }
        return getUser(userLoginName.getUserId());
    }
    
    @Override
    public void applyVCForRegister(UserLoginNameType userLoginNameType, String userLoginName) throws CommonRestException {
        try {
            getUser(userLoginNameType, userLoginName);
            throw new CommonRestException(BaseRestExceptionType.USER_LGOINNAME_EXISTED);
        } catch (UserNotExistedException e) {
            logger.info("user not existed");
        }
        verificationCodeService.generate(userLoginNameType, userLoginName);
    }
    
    @Override
    public User register(UserLoginNameType userLoginNameType, String loginName, String password, String verificationCode) throws CommonRestException {
        User user;
        try {
            user = getUser(userLoginNameType, loginName);
            throw new CommonRestException(BaseRestExceptionType.USER_LGOINNAME_EXISTED);
        } catch (UserNotExistedException e) {
            logger.info("user not existed");
        }
        
        verificationCodeService.validateVerificationCode(userLoginNameType, loginName, verificationCode);
        user = new User();
        user.setPassword(password);
        user.setCreateTime(new Date());
        user.setUpdateTime(user.getCreateTime());
        user = userRepository.save(user);
        
        UserLoginName userLoginName = new UserLoginName();
        userLoginName.setUserId(user.getUserId());
        userLoginName.setUserLoginNameType(userLoginNameType);
        userLoginName.setLoginName(loginName);
        userLoginName.setCreateTime(new Date());
        userLoginName.setUpdateTime(user.getCreateTime());
        userLoginNameRepository.save(userLoginName);
        return user;
    }
    
    @Override
    public User login(UserLoginNameType userLoginNameType, String loginName, String password) throws CommonRestException {
        
        User user = getUser(userLoginNameType, loginName);
        if (StringUtils.isBlank(password) || !password.equals(user.getPassword())) {
            throw new CommonRestException(BaseRestExceptionType.PASSWORD_INCORRECT_TYPE);
        }
        return user;
    }
}
