package com.online.mall.test.polymorphism;

/**
 * @author mgcele
 * @since 1.0.0
 */
public class Employee {
    
    private EmployeeType employeeType;
    
    public Employee(EmployeeType employeeType){
        this.employeeType = employeeType;
    };
    
    int payAmount(){
        return employeeType.payAmount(this);
    }
    
    public int getMonthlySalary(){
        return 1;
    }
    
    public int getCommission(){
        return 2;
    }
    
    public int getBonus(){
        return 3;
    }
}
