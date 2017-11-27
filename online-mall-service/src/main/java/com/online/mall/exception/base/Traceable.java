package com.online.mall.exception.base;

/**
 * @author mgcele
 * @since 1.0.0
 */
public interface Traceable {
    
    String getTraceId();
    
    ExceptionInfo getRootExceptionInfo();
    
    Long getTimeStamp();
    
}
