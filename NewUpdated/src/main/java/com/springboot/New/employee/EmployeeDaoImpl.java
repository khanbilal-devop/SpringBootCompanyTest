/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.employee;

import com.springboot.New.comapny.CompanyCrud;
import com.springboot.New.department.DepartmentCrud;
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
    @Autowired
    CompanyCrud companyCrud;
    @Autowired
    DepartmentCrud departmentCrud;

    public void saveEmployee(Employee employee) {
        try {
            employeeCrud.save(employee);
        } catch (Exception e) {
            System.out.println("Exception in [EmployeeDaoImpl]..[saveEmployee]" + e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    public String checkEmployeeName(String employeeName) {
        try {
            List<Employee> employeeList = employeeCrud.findByEmployeeName(employeeName);
            if (employeeList.isEmpty()) {
                return "NOT FOUND";
            }
            return employeeList.get(0).getEmployeeId();
        } catch (Exception e) {
            System.out.println("Exception in [EmployeeDaoImpl]..[checkEmployeeName] " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        try {
            return employeeCrud.findAll();
        } catch (Exception e) {
            System.out.println("Exception in [EmployeeDaoImpl]..[getAllEmployee] " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public String isEmployeeIdAvailable(String employeeId, String employeeName) {
        try {
            try {
                Employee employee = employeeCrud.getOne(employeeId);
                System.out.println(employee);
                if (employee.getEmployeeName().equals(employeeName)) {
                    return "No";
                }
                return "Yes";
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return "No";
            }
        } catch (Exception e) {
            System.out.println("Exception in [EmployeeDaoImpl]..[isEmployeeIdAvailable] " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteEmployee(String employeeId) {
        try {
            employeeCrud.deleteById(employeeId);
        } catch (Exception e) {
            System.out.println("Exception in [EmployeeDaoImpl]..[deleteEmployee] " + e.getMessage());
            e.printStackTrace();
        }
    }

}
