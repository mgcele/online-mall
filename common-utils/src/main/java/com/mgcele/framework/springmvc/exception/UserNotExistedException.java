package com.mgcele.framework.springmvc.exception;

import com.mgcele.framework.exception.base.BaseException;

/**
 * @author mgcele
 * @since 1.0.0
 */
public class UserNotExistedException extends CommonRestException{
    
    public UserNotExistedException(){
        super(BaseRestExceptionType.USER_NOT_EXISTED_TYPE);
    }
    
    public UserNotExistedException(Throwable e){
        super(BaseRestExceptionType.USER_NOT_EXISTED_TYPE, e);
    }
    
}
