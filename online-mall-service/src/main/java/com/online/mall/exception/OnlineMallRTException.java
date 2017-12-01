package com.online.mall.exception;

import com.mgcele.framework.exception.base.BaseRuntimeException;

/**
 * @author mgcele
 * @since 1.0.0
 */
public class OnlineMallRTException extends BaseRuntimeException {

    public OnlineMallRTException(String msg){
        super("00000", msg);
    }
    
    public OnlineMallRTException(String msg, Throwable e){
        super("00000", msg, e);
    }

}
