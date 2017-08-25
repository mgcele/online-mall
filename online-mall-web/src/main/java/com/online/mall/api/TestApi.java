package com.online.mall.api;

import com.online.mall.service.TestDemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author mgcele
 */
@RestController
@RequestMapping("/api/test")
public class TestApi {
    
    @Resource(name = "testDemoService")
    private TestDemoService testDemoService;
    
}
