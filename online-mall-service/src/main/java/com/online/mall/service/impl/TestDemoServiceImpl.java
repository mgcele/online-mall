package com.online.mall.service.impl;

import com.online.mall.model.TestDemo;
import com.online.mall.repository.TestDemoRepository;
import com.online.mall.service.TestDemoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mgcele
 */
@Service("testDemoService")
public class TestDemoServiceImpl implements TestDemoService{
    
    @Resource(name = "testDemoRepository")
    private TestDemoRepository testDemoRepository;
    
    @Override
    public TestDemo addTestDemo(String name, int age) {
        if (StringUtils.isBlank(name)) {
            throw new RuntimeException("name不能为空！");
        }
        TestDemo testDemo = queryTestDemo(name);
        if (testDemo != null) {
            throw new RuntimeException("姓名已存在！");
        }
        testDemo = new TestDemo();
        testDemo.setName(name);
        testDemo.setAge(age);
        return testDemoRepository.save(testDemo);
    }
    
    @Override
    public TestDemo queryTestDemo(String name) {
        return testDemoRepository.findTestDemoByName(name);
    }
    
    @Override
    public List<TestDemo> queryTestDemos() {
        return testDemoRepository.findAll();
    }
}
