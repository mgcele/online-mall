package com.online.mall.vo.login;

import com.online.mall.enums.UserLoginNameType;
import com.mgcele.framework.utils.serializable.SerializableBase;

/**
 * @author mgcele
 * @since 1.0.0
 */
public class LoginRequest extends SerializableBase{
    
    
    private String userLoginName;
    
    private String password;
    
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
