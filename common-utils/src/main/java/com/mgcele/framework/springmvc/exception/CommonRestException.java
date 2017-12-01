package com.mgcele.framework.springmvc.exception;

import com.mgcele.framework.exception.base.BaseException;

/**
 * @author mgcele
 * @since 1.0.0
 */
public class CommonRestException extends BaseException{
    
    public CommonRestException(ExceptionType type) {
        super(type.getCode(), type.getMsg());
    }
    
    public CommonRestException(ExceptionType type, Throwable e) {
        super(type.getCode(), type.getMsg(), e);
    }
}
