package com.mgcele.framework.exception.base;

import com.mgcele.framework.exception.model.ExceptionInfo;
import com.mgcele.framework.exception.utils.CommonExceptionUtils;
import com.mgcele.framework.exception.utils.ExceptionTraceIdGenerator;
import com.mgcele.framework.system.SystemProperty;

/**
 * @author mgcele
 * @since 1.0.0
 */
public abstract class AbstractBaseNestedException extends Exception implements Describable, Traceable {
    
    private static final long serialVersionUID = 1L;
    private String code;
    private String traceId;
    private final transient Traceable parent;
    private final transient Throwable cause;
    private ExceptionInfo rootExceptionInfo;
    private final Long timestamp;
    
    AbstractBaseNestedException(String code, String msg) {
        super(msg);
        this.code = SystemProperty.getInstance().getSystemName() + code;
        this.timestamp = System.currentTimeMillis();
        this.parent = null;
        this.cause = null;
        this.traceId = ExceptionTraceIdGenerator.getInstance().getTraceId();
        this.rootExceptionInfo = CommonExceptionUtils.extractExceptionInfo(this);
    }
    
    AbstractBaseNestedException(String code, String msg, Throwable e) {
        super(msg);
        this.code = SystemProperty.getInstance().getSystemName() + code;
        this.cause = e;
        if (e instanceof Traceable) {
            this.parent = (Traceable) e;
            this.timestamp = ((Traceable) e).getTimeStamp();
            this.traceId = getTraceId();
            this.rootExceptionInfo = ((Traceable) e).getRootExceptionInfo();
        } else {
            this.parent = null;
            this.timestamp = System.currentTimeMillis();
            this.traceId = getTraceId();
            this.rootExceptionInfo = CommonExceptionUtils.extractExceptionInfo(e);
        }
    }
    
    @Override
    public Throwable getCause() {
        return cause == this ? null : cause;
    }
    
    @Override
    public String getCode() {
        return code;
    }
    
    @Override
    public String toString() {
        return (getClass().getName() + ":") + (getTraceId() == null ? "" : "trace[ " + getTraceId() + " ], ") + (getCode() == null ?
                "" :
                "code[ " + getCode() + " ], ") + (getLocalizedMessage() == null ? "" : "msg[ " + getLocalizedMessage() + " ]");
    }
    
    @Override
    public String getTraceId() {
        if (traceId != null) {
            return traceId;
        } else if (parent != null) {
            return parent.getTraceId();
        } else {
            try {
                traceId = ExceptionTraceIdGenerator.getInstance().getTraceId();
            } catch (Exception e) {
                traceId = null;
            }
            return traceId;
        }
        
    }
    
    @Override
    public ExceptionInfo getRootExceptionInfo() {
        if (rootExceptionInfo != null) {
            return rootExceptionInfo;
        } else if (parent != null) {
            return parent.getRootExceptionInfo();
        } else {
            try {
                rootExceptionInfo = CommonExceptionUtils.extractExceptionInfo(this);
            } catch (Exception e) {
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
