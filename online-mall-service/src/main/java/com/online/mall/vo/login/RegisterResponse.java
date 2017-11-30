package com.online.mall.vo.login;

import com.mgcele.framework.utils.serializable.SerializableBase;

/**
 * @author mgcele
 * @since 1.0.0
 */
public class RegisterResponse extends SerializableBase{
    
    private Long userId;
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
