/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.employee;

import com.springboot.New.comapny.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author oss
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    CompanyService companyService;
    static String employeeId;

    @GetMapping("/register")
    public ModelAndView employeeRegister(ModelAndView modelAndView) {
            modelAndView.setViewName("employee.html");
            return modelAndView;

    }

    @PostMapping("/saving")
    public ModelAndView saveEmployee(Employee employee, ModelAndView modelAndView) {
        try {
            employeeService.saveEmployee(employee);
            modelAndView.setViewName("success.html");
            return modelAndView;
        } catch (Exception e) {
            System.out.println("Exception caught in [EmployeeController]..[saveEmployee]..." + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/checkEmployeeName")
    public @ResponseBody
    String checkEmployeeName(@RequestParam String employeeName) {
        try {
            return (employeeService.checkEmployeeName(employeeName.trim().toLowerCase())).toUpperCase();
        } catch (Exception e) {
            System.out.println("Exception caught in [EmployeeController]..[checkEmployeeName]..." + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/getAllEmployee")
    public @ResponseBody
    List<Employee> getAllEmployee() {
        try {
            return employeeService.getAllEmployee();
        } catch (Exception e) {
            System.out.println("Exception caught in [EmployeeController]..[getAllEmployee]..." + e.getMessage());
            e.printStackTrace();
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
            return employeeService.isEmployeeIdAvailable(employeeId, employeeName);
        } catch (Exception e) {
            System.out.println("Exception caught in [EmployeeController]..[isEmployeeIdAvailable]..." + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping("/deleteEmployee/{employeeIdDelete}")
    public ModelAndView deleteEmployee(@PathVariable String employeeIdDelete, ModelAndView modelAndView) {
        try {
            employeeService.deleteEmployee(employeeIdDelete);
            modelAndView.setViewName("changes.html");
            return modelAndView;
        } catch (Exception e) {
            System.out.println("Exception caught in [EmployeeController]..[deleteEmployee]..." + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/editEmployeeView")
    public ModelAndView editCompany(@RequestParam String employeeIdEdit, ModelAndView modelAndView) {
        employeeId = employeeIdEdit;
        modelAndView.setViewName("employeeUpdate.html");
        return modelAndView;
    }

    @GetMapping("/getEmployeeId")
    public @ResponseBody
    String getEmployeeId() {
        return employeeId;
    }

    @PostMapping("/savingNew")
    public ModelAndView savingNew(Employee employee, ModelAndView modelAndView) {
        try {
            employeeService.saveEmployee(employee);
            modelAndView.setViewName("changes.html");
            return modelAndView;
        } catch (Exception e) {
            System.out.println("Exception caught in [EmployeeController]..[savingNew]..." + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
