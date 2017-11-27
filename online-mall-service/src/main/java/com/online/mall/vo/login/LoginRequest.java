package com.online.mall.vo.login;

import com.online.mall.enums.UserLoginNameType;
import com.online.mall.utils.SerializableBase;

/**
 * @author mgcele
 * @since 1.0.0
 */
public class LoginRequest extends SerializableBase{
    
    private UserLoginNameType userLoginNameType;
    
    private String userLoginName;
    
    private String password;
    
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
}
