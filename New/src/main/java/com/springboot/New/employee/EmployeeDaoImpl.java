/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.employee;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author oss
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    EmployeeCrud employeeCrud;

    public void saveEmployee(Employee employee) {
        employeeCrud.save(employee);
    }

    @Override
    public String checkEmployeeName(String employeeName) {
        List<Employee> employeeList = employeeCrud.findByEmployeeName(employeeName);
        if (employeeList.isEmpty()) {
            return "NOT FOUND";
        }
        return employeeList.get(0).getEmployeeId();
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeCrud.findAll();
    }

    public String isEmployeeIdAvailable(String employeeId,String employeeName) {
       try{ Employee employee = employeeCrud.getOne(employeeId);
             System.out.println(employee);
             if(employee.getEmployeeName().equals(employeeName))
                   return "No";
              return "Yes";
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "No";
        }
    }

}
