package com.online.mall.service;

import com.mgcele.framework.springmvc.exception.CommonRestException;
import com.online.mall.enums.UserLoginNameType;

/**
 * @author mgcele
 * @since 1.0.0
 */
public interface VerificationCodeService {
    
    void generate(UserLoginNameType userLoginNameType, String userLoginName);
    
    void validateVerificationCode(UserLoginNameType userLoginNameType, String userLoginName, String verificationCode) throws CommonRestException;
    
}
