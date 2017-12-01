package com.mgcele.framework.springmvc.exception;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author mgcele
 * @since 1.0.0
 */
public enum BaseRestExceptionType implements ExceptionType{
    
    /** 请求参数错误 */
    IN_VALIDATE_PARAMS("1000", "参数错误"),
    
    PARAM_ENUMS_NOT_FOUND("1001", "请求中的Enum参数[{}]未找到对应服务端实现", true),
    
    IN_VALIDATE_REST_PAGINATION_TYPE("1002", "不支持的RESTful分页类型"),
    
    /** 系统错误 */
    // 需要输入后端系统的代号
    DUBBO_RPC_EXCEPTION("9997", "后端服务通讯错误[{}]", true),
    
    REST_NOT_AUTHORIZED("9998", "REST服务未授权"),
    
    SYSTEM_ERROR("9999", "系统运行时错误");
    
    private String code;
    private String msg;
    
    /**
     * 是否参数化.
     */
    private boolean isParameterized = false;
    
    BaseRestExceptionType(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    
    BaseRestExceptionType(String code, String msg, boolean isParameterized) {
        this.code = code;
        this.msg = msg;
        this.isParameterized = isParameterized;
    }
    
    public static BaseRestExceptionType getByCode(String code) {
        if (StringUtils.isEmpty(code)) {
            return null;
        }
        
        for (BaseRestExceptionType type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        
        return null;
    }
    
    @Override
    public String getCode() {
        return code;
    }
    
    @Override
    public String getMsg() {
        return msg;
    }
    
    /**
     * @return the isParameterized
     */
    public boolean isParameterized() {
        return isParameterized;
    }
    
    /*
     * (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
    
}
