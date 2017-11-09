package com.online.mall.test.polymorphism;

/**
 * @author mgcele
 * @since 1.0.0
 */
public class MainTest {
    
    public static void main(String[] args) {
    
        Employee manager = new Employee(new Manager());
        System.out.println("manager's salary:" + manager.payAmount());
        Employee salesman = new Employee(new Salesman());
        System.out.println("salesman's salary:" + salesman.payAmount());
    
    }
    
}
