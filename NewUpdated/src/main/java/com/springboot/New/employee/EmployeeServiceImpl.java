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
    EmployeeDao employeeDao;

    public void saveEmployee(Employee employee) {
        try {
            employeeDao.saveEmployee(employee);
        } catch (Exception e) {
            System.out.println("Exception in [EmployeeServiceImpl]..[saveEmployee]" + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public String checkEmployeeName(String employeeName) {
        try {
            return employeeDao.checkEmployeeName(employeeName);
        } catch (Exception e) {
            System.out.println("Exception in [EmployeeServiceImpl]..[checkEmployeeName]" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        try {
            return employeeDao.getAllEmployee();
        } catch (Exception e) {
            System.out.println("Exception in [EmployeeServiceImpl]..[getAllEmployee]" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public String isEmployeeIdAvailable(String employeeId, String employeeName) {
        try {
            return employeeDao.isEmployeeIdAvailable(employeeId, employeeName);
        } catch (Exception e) {
            System.out.println("Exception in [EmployeeServiceImpl]..[isEmployeeIdAvailable]" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteEmployee(String employeeId) {
        try {
            employeeDao.deleteEmployee(employeeId);
        } catch (Exception e) {
            System.out.println("Exception in [EmployeeServiceImpl]..[deleteEmployee]" + e.getMessage());
            e.printStackTrace();
        }
    }

}
