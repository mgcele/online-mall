package com.mgcele.framework.springmvc.vo;

import com.mgcele.framework.utils.serializable.SerializableBase;

/**
 * restful返回数据结构
 *
 * @author mgcele
 * @since 1.0.0
 */
public class JsonRestResponseVO extends SerializableBase {
    
    //成功响应的return code为0
    private static final String SUCCESS_STATE_CODE = "0";
    
    private Meta meta;
    
    private Object data;
    
    public JsonRestResponseVO success() {
        this.meta = new Meta(SUCCESS_STATE_CODE);
        return this;
    }
    
    public JsonRestResponseVO success(Object object) {
        success();
        this.data = object;
        return this;
    }
    
    public JsonRestResponseVO failure(String stateCode, String msg) {
        this.meta = new Meta(stateCode, msg);
        return this;
    }
    
    public Meta getMeta() {
        return meta;
    }
    
    public Object getData() {
        return data;
    }
    
    public class Meta {
        
        Meta(String stateCode) {
            this.stateCode = stateCode;
            this.msg = "";
        }
        
        Meta(String stateCode, String msg) {
            this.stateCode = stateCode;
            this.msg = msg;
        }
        
        private String stateCode;
        
        private String msg;
        
        public String getStateCode() {
            return stateCode;
        }
        
        public void setStateCode(String stateCode) {
            this.stateCode = stateCode;
        }
        
        public String getMsg() {
            return msg;
        }
        
        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
    
}
