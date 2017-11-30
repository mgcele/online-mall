package com.online.mall.vo.login;

import com.online.mall.enums.UserLoginNameType;
import com.mgcele.framework.utils.serializable.SerializableBase;

/**
 * @author mgcele
 */
public class RegisterRequest extends SerializableBase{
    
    private UserLoginNameType userLoginNameType;
    
    private String userLoginName;
    
    private String password;
    
    private String verificationCode;
    
    public UserLoginNameType getUserLoginNameType() {
        return userLoginNameType;
    }
    
    public void setUserLoginNameType(UserLoginNameType userLoginNameType) {
        this.userLoginNameType = userLoginNameType;
    }
    
    public String getUserLoginName() {
        return userLoginName;
    }
    
    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getVerificationCode() {
        return verificationCode;
    }
    
    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}
