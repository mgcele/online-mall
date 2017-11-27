package com.online.mall.service;

import com.online.mall.enums.UserLoginNameType;
import com.online.mall.model.User;

/**
 * @author mgcele
 */
public interface UserService {
    
    User register(UserLoginNameType userLoginNameType, String userLoginName, String password, String verificationCode);
    
}
