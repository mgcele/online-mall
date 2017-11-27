package com.online.mall.model;

import com.online.mall.utils.SerializableBase;

/**
 * @author mgcele
 */
public class UserCode extends SerializableBase{
    
    private Long userCodeId;
    
    private String key;
    
    private String value;
    
    public Long getUserCodeId() {
        return userCodeId;
    }
    
    public void setUserCodeId(Long userCodeId) {
        this.userCodeId = userCodeId;
    }
    
    public String getKey() {
        return key;
    }
    
    public void setKey(String key) {
        this.key = key;
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
}
