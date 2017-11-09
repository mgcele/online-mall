package com.online.mall.test.polymorphism;

/**
 * @author mgcele
 * @since 1.0.0
 */
public class Manager extends EmployeeType{
    
    @Override
    public int payAmount(Employee employee) {
        return employee.getMonthlySalary() + employee.getCommission();
    }
    
}
