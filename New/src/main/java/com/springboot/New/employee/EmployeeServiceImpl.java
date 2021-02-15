/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.employee;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author oss
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDaoImpl employeeDaoImpl;

    public void saveEmployee(Employee employee) {
        employeeDaoImpl.saveEmployee(employee);
    }

    @Override
    public String checkEmployeeName(String employeeName) {
        return employeeDaoImpl.checkEmployeeName(employeeName);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeDaoImpl.getAllEmployee();
    }
    
     public String isEmployeeIdAvailable(String employeeId,String employeeName) {
       return employeeDaoImpl.isEmployeeIdAvailable(employeeId,employeeName);
     }
     

}
