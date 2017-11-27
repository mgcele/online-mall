package com.online.mall.framework.exception.base;

import com.online.mall.framework.exception.model.ExceptionInfo;
import com.online.mall.framework.exception.utils.CommonExceptionUtils;
import com.online.mall.framework.exception.utils.ExceptionTraceIdGenerator;

/**
 * @author mgcele
 * @since 1.0.0
 */
public abstract class AbstractBaseRuntimeNestedException extends RuntimeException implements Traceable, Describable{
    
    private static final long serialVersionUID = 1L;
    private final String code;
    private String traceId;
    private final transient Traceable parent;
    private final transient Throwable cause;
    private ExceptionInfo rootExceptionInfo;
    private final Long timestamp;
    
    public AbstractBaseRuntimeNestedException(String code, String msg) {
        super(msg);
        this.cause = null;
        this.code = SystemProperty.getInstance().getSystemName() + code;
        this.traceId = ExceptionTraceIdGenerator.getInstance().getTraceId();
        this.timestamp = System.currentTimeMillis();
        this.parent = null;
        this.rootExceptionInfo = CommonExceptionUtils.extractExceptionInfo(this);
    }
    
    public AbstractBaseRuntimeNestedException(String code, String msg, Throwable e) {
        super(msg);
        this.cause = e;
        this.code = SystemProperty.getInstance().getSystemName() + code;
        if(e instanceof Traceable) {
            this.parent = (Traceable)e;
            this.timestamp = ((Traceable)e).getTimeStamp();
            this.traceId = this.getTraceId();
            this.rootExceptionInfo = ((Traceable)e).getRootExceptionInfo();
        } else {
            this.parent = null;
            this.traceId = this.getTraceId();
            this.timestamp = System.currentTimeMillis();
            this.rootExceptionInfo = CommonExceptionUtils.extractExceptionInfo(e);
        }
        
    }
    
    @Override
    public Throwable getCause() {
        return this.cause;
    }
    
    @Override
    public String getCode() {
        return this.code;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName() + ":");
        sb.append(getTraceId() == null ? "" : "trace[ " + getTraceId() + " ], ");
        sb.append(getCode() == null ? "" : "code[ " + getCode() + " ], ");
        sb.append(getLocalizedMessage() == null ? "" : "msg[ " + getLocalizedMessage() + " ]");
        return sb.toString();
    }
    
    @Override
    public String getTraceId() {
        if(traceId != null) {
            return traceId;
        } else if(parent != null) {
            traceId = parent.getTraceId();
            return traceId;
        } else {
            try {
                traceId = ExceptionTraceIdGenerator.getInstance().getTraceId();
            } catch (Exception var2) {
                traceId = null;
            }
            
            return traceId;
        }
    }
    
    @Override
    public ExceptionInfo getRootExceptionInfo() {
        if(rootExceptionInfo != null) {
            return rootExceptionInfo;
        } else if(parent != null) {
            rootExceptionInfo = parent.getRootExceptionInfo();
            return rootExceptionInfo;
        } else {
            try {
                rootExceptionInfo = CommonExceptionUtils.extractExceptionInfo(this);
            } catch (Exception var2) {
                rootExceptionInfo = null;
            }
            
            return rootExceptionInfo;
        }
    }
    
    @Override
    public Long getTimeStamp() {
        return timestamp;
    }
    
}
