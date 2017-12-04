package com.online.mall.model;

import com.mgcele.framework.utils.serializable.SerializableBase;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * @author mgcele
 */
public class User extends SerializableBase{
    
    @Id
    private Long userId;
    
    @NotBlank
    private String password;
    
    private String userNickname;
    
    private boolean realNameAuthentication;
    
    private String realName;
    
    private String certNo;
    
    @NotBlank
    private Date createTime;
    
    @NotBlank
    private Date updateTime;
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getUserNickname() {
        return userNickname;
    }
    
    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }
    
    public boolean isRealNameAuthentication() {
        return realNameAuthentication;
    }
    
    public void setRealNameAuthentication(boolean realNameAuthentication) {
        this.realNameAuthentication = realNameAuthentication;
    }
    
    public String getRealName() {
        return realName;
    }
    
    public void setRealName(String realName) {
        this.realName = realName;
    }
    
    public String getCertNo() {
        return certNo;
    }
    
    public void setCertNo(String certNo) {
        this.certNo = certNo;
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
}
