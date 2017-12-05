package com.online.mall.service.impl;

import com.mgcele.framework.springmvc.exception.BaseRestExceptionType;
import com.mgcele.framework.springmvc.exception.CommonRestException;
import com.mgcele.framework.utils.RandomUtil;
import com.online.mall.enums.UserLoginNameType;
import com.online.mall.model.UserCode;
import com.online.mall.repository.UserCodeRepository;
import com.online.mall.service.VerificationCodeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author mgcele
 * @since 1.0.0
 */
@Service("verificationCodeService")
public class VerificationCodeServiceImpl implements VerificationCodeService {
    
    @Resource(name = "userCodeRepository")
    private UserCodeRepository userCodeRepository;
    
    @Override
    public void generate(UserLoginNameType userLoginNameType, String userLoginName) {
        UserCode userCode = userCodeRepository.findUserCodeByKey(getKey(userLoginNameType, userLoginName));
        if (userCode != null) {
            userCodeRepository.delete(userCode);
        }
        userCode = new UserCode();
        userCode.setKey(getKey(userLoginNameType, userLoginName));
        userCode.setValue(generateCode());
        userCode.setCreateTime(new Date());
        userCodeRepository.save(userCode);
    }
    
    @Override
    public void validateVerificationCode(UserLoginNameType userLoginNameType, String userLoginName, String verificationCode) throws CommonRestException {
        if (StringUtils.isBlank(verificationCode)) {
            throw new CommonRestException(BaseRestExceptionType.VERIFICATION_CODE_INCORRECT_TYPE);
        }
        UserCode userCode = userCodeRepository.findUserCodeByKey(getKey(userLoginNameType, userLoginName));
        if (userCode == null || (System.currentTimeMillis() - userCode.getCreateTime().getTime()) / 1000 > 180) {
            throw new CommonRestException(BaseRestExceptionType.VERIFICATION_CODE_INCORRECT_TYPE);
        }
        if (!verificationCode.equals(userCode.getValue())) {
            throw new CommonRestException(BaseRestExceptionType.VERIFICATION_CODE_INCORRECT_TYPE);
        }
        userCodeRepository.delete(userCode);
    }
    
    private String getKey(UserLoginNameType userLoginNameType, String userLoginName) {
        return userLoginNameType.getCode() + "-" + userLoginName;
    }
    
    private String generateCode() {
        return RandomUtil.randomInt(666666, 666666) + "";
    }
    
}
