package com.online.mall.api.test;

import com.online.mall.model.TestDemo;
import com.online.mall.service.TestDemoService;
import com.online.mall.utils.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mgcele
 */
@RestController
@RequestMapping("/api/test")
public class TestApi {
    private Logger logger = LoggerFactory.getLogger(TestApi.class);
    
    @Resource(name = "testDemoService")
    private TestDemoService testDemoService;
    
    @GetMapping("save")
    public String save(){
        
        try {
            testDemoService.addTestDemo("爸爸", 10);
        } catch (Exception e) {
            logger.warn("-------------------");
        }
        
        testDemoService.addTestDemo(RandomUtil.getRandomString(2), RandomUtil.randomInt(2));
        
        return "ok";
    }
    
    @GetMapping("findByName")
    public TestDemo findByName(){
        return testDemoService.queryTestDemo("爸爸");
    }
    
    @GetMapping("find")
    public List<TestDemo> find(){
        return testDemoService.queryTestDemos();
    }
    
}
