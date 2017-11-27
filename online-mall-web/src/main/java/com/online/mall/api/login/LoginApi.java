package com.online.mall.api.login;

import com.online.mall.vo.login.LoginResponse;
import com.online.mall.vo.login.RegisterRequest;
import com.online.mall.vo.login.RegisterResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mgcele
 * @since 1.0.0
 */
@RestController
public class LoginApi {
    
    @PostMapping("/register")
    public RegisterResponse regster(@RequestBody RegisterRequest request){
        return new RegisterResponse();
    }
    
    @PostMapping("/login")
    public LoginResponse login(){
        return new LoginResponse();
    }
    
    
}
