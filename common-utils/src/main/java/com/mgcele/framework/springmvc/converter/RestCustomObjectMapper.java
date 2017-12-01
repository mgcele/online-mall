package com.mgcele.framework.springmvc.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.mgcele.framework.springmvc.specification.IRestJsonable;

import java.util.Map;

/**
 * 自定义ObjectMapper，实现特定的object转json输出
 *
 * @author mgcele
 * @since 1.0.0
 */
public class RestCustomObjectMapper extends ObjectMapper {
    
    public RestCustomObjectMapper(){
        this(true);
    }
    
    public RestCustomObjectMapper(boolean jsonable){
        super();
        SimpleModule module = new SimpleModule();
        //Long && long 类型转换注册
        module.addSerializer(Long.class, new RestLongTypeResponseSerializer());
        module.addSerializer(Long.TYPE, ToStringSerializer.instance);
        //指定对象转json注册
        if (jsonable) {//防止重复创建对象
            module.addSerializer(IRestJsonable.class, new BaseRestResponseSerializer());
            module.addSerializer(Map.class, new RestModelAndViewResponseSerializer());
        }
        registerModule(module);
    }
    
}
