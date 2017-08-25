package com.online.mall.service;

import com.online.mall.model.TestDemo;

import java.util.List;

/**
 * @author mgcele
 */
public interface TestDemoService {

    TestDemo addTestDemo(String name, int age);
    
    TestDemo queryTestDemo(String name);
    
    List<TestDemo> queryTestDemos();

}
