package com.mgcele.framework.springmvc.exception;

import com.mgcele.framework.exception.base.BaseRuntimeException;

/**
 * @author mgcele
 * @since 1.0.0
 */
public class CommonRestRuntimeException extends BaseRuntimeException{
    public CommonRestRuntimeException(ExceptionType type) {
        super(type.getCode(), type.getMsg());
    }
    
    public CommonRestRuntimeException(ExceptionType type, Throwable e) {
        super(type.getCode(), type.getMsg(), e);
    }
}
