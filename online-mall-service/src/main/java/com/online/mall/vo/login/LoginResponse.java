package com.online.mall.vo.login;

import com.online.mall.utils.SerializableBase;

/**
 * @author mgcele
 * @since 1.0.0
 */
public class LoginResponse extends SerializableBase{
    
    private Long userId;
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
