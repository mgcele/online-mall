package com.online.mall.enums;

/**
 * @author mgcele
 */
public enum UserLoginNameType {
    
    EMAIL(0, "邮箱"),
    
    ;
    
    public UserLoginNameType getByCode(Integer code) {
        if (code == null) {
            return null;
        }
        
        for(UserLoginNameType userLoginNameType : values()) {
            if (code.equals(userLoginNameType.getCode())) {
                return userLoginNameType;
            }
        }
        
        return null;
    }
    
    public Integer getCode(){
        return this.code;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    private Integer code;
    private String description;
    
    UserLoginNameType(Integer code, String description){
        this.code = code;
        this.description = description;
    }
    
}
