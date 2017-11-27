package com.online.mall.exception;

import com.online.mall.exception.base.BaseException;

/**
 * @author mgcele
 * @since 1.0.0
 */
public class VerificationCodeIncorrectException extends BaseException {
    
    public VerificationCodeIncorrectException() {
        super("20001", "验证码不正确");
    }
    
    public VerificationCodeIncorrectException(Throwable e) {
        super("20001", "验证码不正确", e);
    }
    
}
