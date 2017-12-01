package com.online.mall.api.user;

import com.mgcele.framework.exception.BaseException;
import com.mgcele.framework.exception.BaseRuntimeException;
import com.mgcele.framework.springmvc.vo.BaseRestResponse;
import com.online.mall.vo.login.LoginResponse;
import com.online.mall.vo.login.RegisterRequest;
import com.online.mall.vo.login.RegisterResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mgcele
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserRestApi {
    
    @GetMapping("/test")
    public void test() {
        throw new BaseRuntimeException("111", "222");
    }
    
    @GetMapping("/test2")
    public void test2() throws BaseException {
        throw new BaseException("222", "111");
    }
    
    @PostMapping("/register")
    @ResponseStatus
    public RegisterResponse register(@RequestBody RegisterRequest request) {
        return new RegisterResponse();
    }
    
    @PostMapping("/login")
    public LoginResponse login() {
        return new LoginResponse();
    }
    
}
