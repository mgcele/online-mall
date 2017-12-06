package com.online.mall.api.user;

import com.mgcele.framework.exception.base.BaseException;
import com.mgcele.framework.exception.base.BaseRuntimeException;
import com.mgcele.framework.springmvc.exception.CommonRestException;
import com.online.mall.enums.UserLoginNameType;
import com.online.mall.model.User;
import com.online.mall.service.UserService;
import com.online.mall.vo.login.LoginRequest;
import com.online.mall.vo.login.LoginResponse;
import com.online.mall.vo.login.RegisterRequest;
import com.online.mall.vo.login.RegisterResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author mgcele
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserRestApi {
    
    @Resource(name = "userService")
    private UserService userService;
    
    @GetMapping("/vc/{loginname}")
    public void applyVCForRegister(@PathVariable(value = "loginname") String loginName) throws CommonRestException {
        userService.applyVCForRegister(UserLoginNameType.EMAIL, loginName);
    }
    
    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterRequest request) throws CommonRestException {
        User user = userService.register(UserLoginNameType.EMAIL, request.getUserLoginName(), request.getPassword(), request.getVerificationCode());
        RegisterResponse response = new RegisterResponse();
        response.setUserId(user.getUserId());
        return response;
    }
    
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) throws CommonRestException {
        User user = userService.login(UserLoginNameType.EMAIL, request.getUserLoginName(), request.getPassword());
        LoginResponse response = new LoginResponse();
        response.setUserId(user.getUserId());
        return response;
    }
    
}
