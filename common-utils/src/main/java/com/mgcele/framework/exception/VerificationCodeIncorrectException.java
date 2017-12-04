package com.mgcele.framework.exception;

import com.mgcele.framework.exception.base.BaseException;
import com.mgcele.framework.springmvc.exception.BaseRestExceptionType;

/**
 * @author mgcele
 * @since 1.0.0
 */
public class VerificationCodeIncorrectException extends BaseException {
    
    public VerificationCodeIncorrectException() {
        super(BaseRestExceptionType.VERIFICATION_CODE_INCORRECT_TYPE.getCode(), BaseRestExceptionType.VERIFICATION_CODE_INCORRECT_TYPE.getMsg());
    }
    
    public VerificationCodeIncorrectException(Throwable e) {
        super(BaseRestExceptionType.VERIFICATION_CODE_INCORRECT_TYPE.getCode(), BaseRestExceptionType.VERIFICATION_CODE_INCORRECT_TYPE.getMsg(), e);
    }
    
}
