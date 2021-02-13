/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.employee;

import com.springboot.New.*;
import com.springboot.New.department.Department;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import com.springboot.New.comapny.CompanyServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;


/**
 *
 * @author oss
 */
@org.springframework.stereotype.Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;
    @Autowired
    CompanyServiceImpl companyServiceImpl;

    @GetMapping("/register")
    public ModelAndView employeeRegister(ModelAndView modelAndView) {
        try{
        modelAndView.setViewName("employee.html");
        return modelAndView;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/saving")
    public ModelAndView saveEmployee(Employee employee, ModelAndView modelAndView) {
        try{
        System.out.println(employee.getEmployeeHobby() + " this is employee hobby ");
        employeeServiceImpl.save(employee);
        modelAndView.setViewName("employee.html");
        return modelAndView;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping(value = "/checkEmployeeName", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<String> checkEmployeeName(@RequestBody Json json) {
        try{
        List<String> employeeIdList = new ArrayList<String>();
        employeeIdList.add((employeeServiceImpl.checkEmployeeName(json.getAttribute().trim().toLowerCase())).toUpperCase());
        return employeeIdList;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }


}
