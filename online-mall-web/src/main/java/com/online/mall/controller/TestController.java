package com.online.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mgcele
 */
@Controller
@RequestMapping("/test")
public class TestController {
    
    @GetMapping
    public String test() {
        return "test";
    }
    
}
