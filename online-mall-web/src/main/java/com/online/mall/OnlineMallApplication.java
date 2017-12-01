package com.online.mall;

import com.mgcele.framework.springmvc.converter.RestCustomObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mgcele
 */
@SpringBootApplication
@ServletComponentScan
public class OnlineMallApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(OnlineMallApplication.class);
    }
    
    @Bean
    public HttpMessageConverters httpMessageConverters() {
        RestCustomObjectMapper restCustomObjectMapper = new RestCustomObjectMapper();
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter(restCustomObjectMapper);
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
        return new HttpMessageConverters((HttpMessageConverter<?>) mappingJackson2HttpMessageConverter);
    }
    
    
}
