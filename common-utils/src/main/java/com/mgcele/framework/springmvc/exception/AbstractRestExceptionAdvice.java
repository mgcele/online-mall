package com.mgcele.framework.springmvc.exception;

import com.mgcele.framework.exception.BaseException;
import com.mgcele.framework.exception.BaseRuntimeException;
import com.mgcele.framework.springmvc.vo.JsonRestResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

/**
 * 默认的REST异常处理advice
 *
 * @author mgcele
 * @since 1.0.0
 */
public abstract class AbstractRestExceptionAdvice {
    
    private Logger logger = LoggerFactory.getLogger(AbstractRestExceptionAdvice.class);
    
    @ExceptionHandler(BindException.class)
    public ResponseEntity<JsonRestResponseVO> bindException(BindException e) {
        logger.warn(e.getMessage());
        JsonRestResponseVO result = new JsonRestResponseVO()
                .failure(BaseRestExceptionType.IN_VALIDATE_PARAMS.getCode(), BaseRestExceptionType.IN_VALIDATE_PARAMS.getMsg());
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<JsonRestResponseVO> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        logger.warn(e.getMessage());
        JsonRestResponseVO result = new JsonRestResponseVO()
                .failure(BaseRestExceptionType.IN_VALIDATE_PARAMS.getCode(), BaseRestExceptionType.IN_VALIDATE_PARAMS.getMsg());
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(BaseRuntimeException.class)
    public ResponseEntity<JsonRestResponseVO> baseRTException(BaseRuntimeException e) {
        logger.warn(e.getTraceId() + ":" + e.getMessage(), e);
        JsonRestResponseVO result = new JsonRestResponseVO().failure(e.getCode(), e.getMessage());
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<JsonRestResponseVO> baseException(BaseException e) {
        logger.error(e.getTraceId() + ":" + e.getMessage(), e);
        JsonRestResponseVO result = new JsonRestResponseVO().failure(e.getCode(), e.getMessage());
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<JsonRestResponseVO> handleHttpMessageNotReadableException() {
        JsonRestResponseVO result = new JsonRestResponseVO().failure("HTTP400", "bad request");
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }
    
    /**
     * 404 - Not Found
     */
    @SuppressWarnings("deprecation")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchRequestHandlingMethodException.class)
    public ResponseEntity<JsonRestResponseVO> handleHttpMessageNotFoundException() {
        JsonRestResponseVO result = new JsonRestResponseVO().failure("HTTP404", "NOT_FOUND");
        return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
    }
    
    /**
     * 405 - Method Not Allowed
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<JsonRestResponseVO> handleHttpRequestMethodNotSupportedException() {
        JsonRestResponseVO result = new JsonRestResponseVO().failure("HTTP405", "METHOD_NOT_ALLOWED");
        return new ResponseEntity<>(result, HttpStatus.METHOD_NOT_ALLOWED);
    }
    
    /**
     * 500 - Internal Server Error 一般用来捕获未处理的异常
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<JsonRestResponseVO> handleException(Exception e) {
        logger.error(e.getMessage(), e);
        JsonRestResponseVO result = new JsonRestResponseVO().failure("HTTP500", "运行时错误");
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}
