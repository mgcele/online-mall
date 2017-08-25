package com.online.mall.repository;

import com.online.mall.model.TestDemo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author mgcele
 */
public interface TestDemoRepository extends MongoRepository<TestDemo, String>{
    
    TestDemo findTestDemoByName(String name);
    
}
