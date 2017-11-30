package com.mgcele.framework.identifier;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author mgcele
 * @since 1.0.0
 */

public class SnowflakeIDElement implements Serializable {
    
    /**
     *
     */
    private static final long serialVersionUID = 5392219277256664953L;
    
    private Long id;
    
    public SnowflakeIDElement(Long id) {
        this.id = id;
    }
    
    /**
     * 生成id时间
     * 时间格式 ：yyyy-MM-dd HH:mm:ss.SSS
     */
    private Date date;
    
    /**
     * 业务号
     */
    private long regionId;
    
    /**
     * 机器号
     */
    private long workerId;
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public long getRegionId() {
        return regionId;
    }
    
    public void setRegionId(long regionId) {
        this.regionId = regionId;
    }
    
    public long getWorkerId() {
        return workerId;
    }
    
    public void setWorkerId(long workerId) {
        this.workerId = workerId;
    }
    
    @Override
    public String toString() {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return "id=[" + id + "],date=[" + sdf.format(date) + "],regionId=[" + regionId + "],workerId=[" + workerId + "]";
    }
    
    public Long getId() {
        return id;
    }
    
}