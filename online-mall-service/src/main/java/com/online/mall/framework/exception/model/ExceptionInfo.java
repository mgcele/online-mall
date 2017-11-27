package com.online.mall.framework.exception.model;

import java.io.Serializable;

/**
 * @author mgcele
 * @since 1.0.0
 */
public class ExceptionInfo implements Serializable {
    private static final long serialVersionUID = 999L;
    
    private String code;
    private String traceId;
    private String interceptTime;
    private String interceptedClass;
    private String interceptedMethod;
    private String interceptedLine;
    private String parameterValue;
    private String exceptionClass;
    private String exceptionMessage;
    private String rootException;
    private String rootExceptionMsg;
    private String rootCauseSpotClass;
    private String rootCauseSpotMethod;
    private String rootCauseSpotLine;
    private String fullStackTrace;
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getTraceId() {
        return traceId;
    }
    
    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }
    
    public String getInterceptTime() {
        return interceptTime;
    }
    
    public void setInterceptTime(String interceptTime) {
        this.interceptTime = interceptTime;
    }
    
    public String getInterceptedClass() {
        return interceptedClass;
    }
    
    public void setInterceptedClass(String interceptedClass) {
        this.interceptedClass = interceptedClass;
    }
    
    public String getInterceptedMethod() {
        return interceptedMethod;
    }
    
    public void setInterceptedMethod(String interceptedMethod) {
        this.interceptedMethod = interceptedMethod;
    }
    
    public String getInterceptedLine() {
        return interceptedLine;
    }
    
    public void setInterceptedLine(String interceptedLine) {
        this.interceptedLine = interceptedLine;
    }
    
    public String getParameterValue() {
        return parameterValue;
    }
    
    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }
    
    public String getExceptionClass() {
        return exceptionClass;
    }
    
    public void setExceptionClass(String exceptionClass) {
        this.exceptionClass = exceptionClass;
    }
    
    public String getExceptionMessage() {
        return exceptionMessage;
    }
    
    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
    
    public String getRootException() {
        return rootException;
    }
    
    public void setRootException(String rootException) {
        this.rootException = rootException;
    }
    
    public String getRootExceptionMsg() {
        return rootExceptionMsg;
    }
    
    public void setRootExceptionMsg(String rootExceptionMsg) {
        this.rootExceptionMsg = rootExceptionMsg;
    }
    
    public String getRootCauseSpotClass() {
        return rootCauseSpotClass;
    }
    
    public void setRootCauseSpotClass(String rootCauseSpotClass) {
        this.rootCauseSpotClass = rootCauseSpotClass;
    }
    
    public String getRootCauseSpotMethod() {
        return rootCauseSpotMethod;
    }
    
    public void setRootCauseSpotMethod(String rootCauseSpotMethod) {
        this.rootCauseSpotMethod = rootCauseSpotMethod;
    }
    
    public String getRootCauseSpotLine() {
        return rootCauseSpotLine;
    }
    
    public void setRootCauseSpotLine(String rootCauseSpotLine) {
        this.rootCauseSpotLine = rootCauseSpotLine;
    }
    
    public String getFullStackTrace() {
        return fullStackTrace;
    }
    
    public void setFullStackTrace(String fullStackTrace) {
        this.fullStackTrace = fullStackTrace;
    }
    
    @Override
    public String toString() {
        String sb = (this.traceId == null ? "" : "trace[ " + this.traceId + " ], ") + (this.code == null ? "" : "code[ " + this.code + " ], ") + (
                this.exceptionClass == null ? "" : "exception[ " + this.exceptionClass + " ]") + (this.exceptionMessage == null ?
                "" :
                "message[ " + this.exceptionMessage + " ]");
        return sb;
    }
}
