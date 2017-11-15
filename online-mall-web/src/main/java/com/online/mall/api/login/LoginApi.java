package com.online.mall.api.login;

import com.online.mall.vo.login.LoginResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mgcele
 * @since 1.0.0
 */
@RestController
public class LoginApi {
    
    @PostMapping("/login")
    public LoginResponse login(){
        return new LoginResponse();
    }
    
}
