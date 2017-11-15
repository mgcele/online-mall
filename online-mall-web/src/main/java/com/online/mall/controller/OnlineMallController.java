package com.online.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author mgcele
 * @since 1.0.0
 */
@Controller
public class OnlineMallController {
    
    @GetMapping("/login")
    public String login(){
        return "/index/login";
    }
    
}
