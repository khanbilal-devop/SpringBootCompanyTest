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
public class EmployeeServiceImpl implements EmployeeService{
    
    @Autowired
    EmployeeDaoImpl employeeDaoImpl;
    
    public void save(Employee employee){
        employeeDaoImpl.save(employee);
    }

    @Override
    public String checkEmployeeName(String employeeName) {
      return employeeDaoImpl.checkEmployeeName(employeeName);
    }

 
}
