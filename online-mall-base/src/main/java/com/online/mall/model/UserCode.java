package com.online.mall.model;

import com.mgcele.framework.utils.serializable.SerializableBase;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * @author mgcele
 */
public class UserCode extends SerializableBase{
    
    @Id
    private Long userCodeId;
    
    private String key;
    
    private String value;
    
    private Date createTime;
    
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
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
