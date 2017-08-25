package com.online.mall.model;

import com.online.mall.util.SerializableBase;
import org.springframework.data.annotation.Id;

/**
 * @author mgcele
 * 测试demo
 */
public class TestDemo extends SerializableBase{

    @Id
    private String id;
    
    private String name;
    
    private int age;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
}
