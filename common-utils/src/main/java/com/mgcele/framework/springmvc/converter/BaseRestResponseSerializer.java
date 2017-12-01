package com.mgcele.framework.springmvc.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.mgcele.framework.springmvc.specification.IRestJsonable;
import com.mgcele.framework.springmvc.vo.JsonRestResponseVO;

import java.io.IOException;

/**
 * @author mgcele
 * @since 1.0.0
 */
public class BaseRestResponseSerializer extends JsonSerializer<IRestJsonable> {
    public static final ObjectMapper MAPPER = new RestCustomObjectMapper(false);
    
    @Override
    public void serialize(IRestJsonable value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        MAPPER.writer().writeValue(gen, new JsonRestResponseVO().success(value));
    }
}
