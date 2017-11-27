package com.online.mall.controller.test;

import com.online.mall.service.TestDemoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author mgcele
 */
@Controller
@RequestMapping("/test")
public class TestController {
    
    @GetMapping
    public String test() {
        return "test/test";
    }
    
}
