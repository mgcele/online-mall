package com.mgcele.framework.springmvc.exception;

import com.mgcele.framework.exception.base.BaseRuntimeException;

/**
 * @author mgcele
 * @since 1.0.0
 */
public class CommonRestRuntimeException extends BaseRuntimeException{
    
    private static final ExceptionType type = BaseRestExceptionType.SYSTEM_ERROR;
    
    public CommonRestRuntimeException() {
        super(type.getCode(), type.getMsg());
    }
    
    public CommonRestRuntimeException(Throwable e) {
        super(type.getCode(), type.getMsg(), e);
    }
}
