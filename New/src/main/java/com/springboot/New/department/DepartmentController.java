/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.department;

import com.springboot.New.Json;
import com.springboot.New.comapny.CompanyServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author oss
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentServiceImpl departmentServiceImpl;
    @Autowired
    CompanyServiceImpl companyServiceImpl;

    @GetMapping("/register")
    public ModelAndView departmentRegister(ModelAndView modelAndView) {
        modelAndView.setViewName("department.html");
        return modelAndView;
    }

    @PostMapping("/saving")
    public ModelAndView departmentSaving(Department department, ModelAndView modelAndView, @RequestParam("departmentCompanyId") String departmentCompanyId) {
        try{
        departmentServiceImpl.save(department, departmentCompanyId);
    
        modelAndView.setViewName("department.html");
        return modelAndView;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping(value = "/checkDepartmentName")
    public @ResponseBody
    String checkDepartmentName(@RequestBody Json json) {
    try{
     return  departmentServiceImpl.findIdByDepartmentName(json.getAttribute().trim().toLowerCase()).toUpperCase(); 
    }
    catch(Exception e){
        System.out.println(e.getMessage());
        return null;
    }
    }

    @PostMapping(value = "/loadAllDepartment", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Department> loadAllDepartment(@RequestBody Json json) {
        try{
        List<Department> departmentList = companyServiceImpl.getAllDepartmentByCompanyId(json.getAttribute());
        return departmentList;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
