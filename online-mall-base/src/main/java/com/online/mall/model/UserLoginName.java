package com.online.mall.model;

import com.online.mall.enums.UserLoginNameType;
import com.online.mall.utils.SerializableBase;

import java.util.Date;

/**
 * @author mgcele
 */
public class UserLoginName extends SerializableBase{
    
    private Long userLoginNameId;
    
    private Long userId;
    
    private UserLoginNameType userLoginNameType;
    
    private String loginName;
    
    private Date createTime;
    
    private Date updateTime;
    
    public Long getUserLoginNameId() {
        return userLoginNameId;
    }
    
    public void setUserLoginNameId(Long userLoginNameId) {
        this.userLoginNameId = userLoginNameId;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public UserLoginNameType getUserLoginNameType() {
        return userLoginNameType;
    }
    
    public void setUserLoginNameType(UserLoginNameType userLoginNameType) {
        this.userLoginNameType = userLoginNameType;
    }
    
    public String getLoginName() {
        return loginName;
    }
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public Date getUpdateTime() {
        return updateTime;
    }
    
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
