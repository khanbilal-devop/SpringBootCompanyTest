/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.springboot.New.comapny.CompanyServiceImpl;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

/**
 *
 * @author oss
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;
    @Autowired
    CompanyServiceImpl companyServiceImpl;

    @GetMapping("/register")
    public ModelAndView employeeRegister(ModelAndView modelAndView) {
        try {
            modelAndView.setViewName("employee.html");
            return modelAndView;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/saving")
    public ModelAndView saveEmployee(Employee employee, ModelAndView modelAndView) {
        try {
            employeeServiceImpl.saveEmployee(employee);
            modelAndView.setViewName("employee.html");
            return modelAndView;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/checkEmployeeName")
    public @ResponseBody
    String checkEmployeeName(@RequestParam String employeeName) {
        try {
            return (employeeServiceImpl.checkEmployeeName(employeeName.trim().toLowerCase())).toUpperCase();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/getAllEmployee")
    public @ResponseBody
    List<Employee> getAllEmployee() {
        try {
            return employeeServiceImpl.getAllEmployee();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/displayAllEmployee")
    public ModelAndView displayAllEmployee(ModelAndView modelAndView) {
        modelAndView.setViewName("employeeDisplay.html");
        return modelAndView;
    }

    @GetMapping("/isEmployeeIdAvailable")
    public @ResponseBody
    String isEmployeeIdAvailable(@RequestParam String employeeId, @RequestParam String employeeName) {
        try {
            return employeeServiceImpl.isEmployeeIdAvailable(employeeId, employeeName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
