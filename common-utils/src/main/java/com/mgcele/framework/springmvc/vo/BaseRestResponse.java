package com.mgcele.framework.springmvc.vo;

import com.mgcele.framework.springmvc.specification.IRestJsonable;
import com.mgcele.framework.utils.serializable.SerializableBase;

/**
 * @author mgcele
 * @since 1.0.0
 */
public class BaseRestResponse extends SerializableBase implements IRestJsonable{
    
    private String requestId;
    
    @Override
    public String getRequestId() {
        return requestId;
    }
    
    @Override
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
