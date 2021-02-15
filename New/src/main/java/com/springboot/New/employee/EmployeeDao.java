/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.employee;

import java.util.List;

/**
 *
 * @author oss
 */
public interface EmployeeDao {

    public void saveEmployee(Employee employee);

    public String checkEmployeeName(String employeeName);
    
    public List<Employee> getAllEmployee();
    
    public String isEmployeeIdAvailable(String employeeId,String employeeName);
}
