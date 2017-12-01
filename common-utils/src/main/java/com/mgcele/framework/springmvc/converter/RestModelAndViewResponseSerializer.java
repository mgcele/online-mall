package com.mgcele.framework.springmvc.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.mgcele.framework.springmvc.vo.JsonRestResponseVO;

import java.io.IOException;
import java.util.Map;

/**
 * @author mgcele
 * @since 1.0.0
 */
public class RestModelAndViewResponseSerializer extends JsonSerializer<Map>{
    
    
    @Override
    public void serialize(Map value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        BaseRestResponseSerializer.MAPPER.writer().writeValue(gen, new JsonRestResponseVO().success(value));
    }
}
