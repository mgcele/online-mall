package com.online.mall.framework.exception.base;

import com.online.mall.framework.exception.model.ExceptionInfo;

/**
 * @author mgcele
 * @since 1.0.0
 */
public interface Traceable {
    
    String getTraceId();
    
    ExceptionInfo getRootExceptionInfo();
    
    Long getTimeStamp();
    
}
