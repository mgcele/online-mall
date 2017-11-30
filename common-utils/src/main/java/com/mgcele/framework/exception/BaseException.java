package com.mgcele.framework.exception;

import com.mgcele.framework.exception.base.AbstractBaseNestedException;

/**
 * @author mgcele
 * @since 1.0.0
 */
public class BaseException extends AbstractBaseNestedException {
    
    private static final long serialVersionUID = 1L;
    
    public BaseException(String code, String msg) {
        super(code, msg);
    }
    
    public BaseException(String code, String msg, Throwable e) {
        super(code, msg, e);
    }
    
    
}
