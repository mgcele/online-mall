package com.online.mall.service;

import com.mgcele.framework.springmvc.exception.CommonRestException;
import com.online.mall.enums.UserLoginNameType;
import com.online.mall.model.User;

/**
 * @author mgcele
 */
public interface UserService {
    
    User getUser(Long userId) throws CommonRestException;
    
    User getUser(UserLoginNameType userLoginNameType, String loginName) throws CommonRestException;
    
    void applyVCForRegister(UserLoginNameType userLoginNameType, String userLoginName) throws CommonRestException;
    
    User register(UserLoginNameType userLoginNameType, String loginName, String password, String verificationCode) throws CommonRestException;
    
    User login(UserLoginNameType userLoginNameType, String loginName, String password) throws CommonRestException;
    
}
