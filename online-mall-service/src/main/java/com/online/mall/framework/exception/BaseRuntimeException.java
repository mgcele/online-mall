package com.online.mall.framework.exception;

import com.online.mall.framework.exception.base.AbstractBaseRuntimeNestedException;

/**
 * @author mgcele
 * @since 1.0.0
 */
public class BaseRuntimeException extends AbstractBaseRuntimeNestedException {
    
    private static final long serialVersionUID = 1L;
    
    public BaseRuntimeException(String code, String msg) {
        super(code, msg);
    }
    
    public BaseRuntimeException(String code, String msg, Throwable e) {
        super(code, msg, e);
    }
}
