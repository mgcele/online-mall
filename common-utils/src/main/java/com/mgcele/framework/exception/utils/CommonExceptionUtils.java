package com.mgcele.framework.exception.utils;

import com.mgcele.framework.exception.base.Describable;
import com.mgcele.framework.exception.base.Traceable;
import com.mgcele.framework.exception.model.ConfigConstant;
import com.mgcele.framework.exception.model.ExceptionInfo;
import org.apache.commons.lang3.StringUtils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author mgcele
 * @since 1.0.0
 */
public class CommonExceptionUtils {
    
    private CommonExceptionUtils() {
    
    }
    
    //Build a message for the given base message and root cause.
    public static String buildMessages(String message, Throwable cause) {
        if (cause != null) {
            StringBuilder sb = new StringBuilder();
            if (StringUtils.isNotBlank(message)) {
                sb.append(message).append("; ");
            }
            sb.append("nested exception is ").append(cause);
            return sb.toString();
        } else {
            return message;
        }
    }
    
    //得到指定异常的rootCause
    public static Throwable getRootCause(Throwable ex) {
        Throwable rootCause = null;
        for(Throwable cause = ex.getCause(); cause != null && cause != rootCause; cause = cause.getCause()) {
            rootCause = cause;
        }
        return rootCause;
    }
    
    //得到指定异常的rootCause,如果没有rootCause,则把参数指定的异常作为rootCause, 以免返回null
    public static Throwable getMostSpecificCause(Throwable ex) {
        Throwable rootCause = getRootCause(ex);
        return rootCause != null ? rootCause : ex;
    }
    
    //todo to understand
    //获取异常堆栈信息
    public static String getExceptionStackTrace(Throwable ex) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        pw.close();
        return sw.toString();
    }
    
    //获取最详细的异常信息
    public static String getMostSpecificCauseMessageInfo(Throwable ex){
        Throwable rootCause = getMostSpecificCause(ex);
        StackTraceElement[] elements = rootCause.getStackTrace();
        String rootException = rootCause.getClass().getName();
        String rootExceptionMsg = rootCause.getLocalizedMessage();
        String rootCauseSpotClass = elements[0].getClassName();
        String rootCauseSpotMethod = elements[0].getMethodName();
        Integer rootCauseSpotLine =elements[0].getLineNumber();
        StringBuilder sbdr = new StringBuilder(ConfigConstant.LINE_SEPARATOR);
        sbdr.append("[Root Exception]: ");
        sbdr.append(rootException);
        sbdr.append(ConfigConstant.LINE_SEPARATOR);
        sbdr.append("[Root Exception Message]: ");
        sbdr.append(rootExceptionMsg);
        sbdr.append(ConfigConstant.LINE_SEPARATOR);
        sbdr.append("[Root Exception throwed on]: ");
        sbdr.append(rootCauseSpotClass);
        sbdr.append(".");
        sbdr.append(rootCauseSpotMethod);
        sbdr.append("  Line:");
        sbdr.append(rootCauseSpotLine);
        return sbdr.toString();
    }
    
    public static ExceptionInfo extractExceptionInfo(Throwable e) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        ExceptionInfo exceptionInfo = new ExceptionInfo();
        if (e instanceof Traceable) {
            exceptionInfo.setTraceId(((Traceable) e).getTraceId());
            exceptionInfo.setInterceptTime(sdf.format(new Date(((Traceable) e).getTimeStamp())));
        } else {
            exceptionInfo.setInterceptTime(sdf.format(new Date()));
        }
        if (e instanceof Describable) {
            exceptionInfo.setCode(((Describable) e).getCode());
        }
        StackTraceElement[] elements = e.getStackTrace();
        exceptionInfo.setExceptionClass(e.getClass().getName());
        try {
            exceptionInfo.setExceptionMessage(e.getMessage());
        } catch (Exception ex) {
            //todo why need catch Exception
        }
        exceptionInfo.setInterceptedClass(elements[0].getClassName());
        exceptionInfo.setInterceptedMethod(elements[0].getMethodName());
        exceptionInfo.setInterceptedLine(Integer.toString(elements[0].getLineNumber()));
        Throwable rootCause = getMostSpecificCause(e);
        if (rootCause != null && rootCause != e) {
            StackTraceElement[] rootElements = rootCause.getStackTrace();
            exceptionInfo.setRootException(rootCause.getClass().getName());
            try {
                exceptionInfo.setRootExceptionMsg(rootCause.getMessage());
            } catch (Exception ex) {
                //todo why need catch Exception
            }
            exceptionInfo.setRootCauseSpotClass(rootElements[0].getClassName());
            exceptionInfo.setRootCauseSpotMethod(rootElements[0].getMethodName());
            exceptionInfo.setRootCauseSpotLine(Integer.toString(rootElements[0].getLineNumber()));
        }
        return exceptionInfo;
    }
    
}
