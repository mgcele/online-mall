package com.online.mall.config;

import com.mgcele.framework.springmvc.exception.advice.AbstractRestExceptionAdvice;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mgcele
 * @since 1.0.0
 */
@ControllerAdvice(annotations = RestController.class)
public class RestControllerAdvice extends AbstractRestExceptionAdvice{
}
