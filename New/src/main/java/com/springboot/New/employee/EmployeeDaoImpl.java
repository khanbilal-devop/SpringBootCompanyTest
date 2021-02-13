/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author oss
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao{
      
    @Autowired
    EmployeeCrud employeeCrud;
    
      public void save(Employee employee){
          employeeCrud.save(employee);
      }

    @Override
    public String checkEmployeeName(String employeeName) {
        List<Employee> employeeList = employeeCrud.findEmployeeByEmployeeName(employeeName);
      if(employeeList.isEmpty())
              return "NOT FOUND";
         return employeeList.get(0).getemployeeId();
        
    }
}
