/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.department;

import com.springboot.New.comapny.CompanyServiceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView saveDepartment(Department department, ModelAndView modelAndView, @RequestParam String departmentCompanyId) {
        try {
            departmentServiceImpl.saveDepartment(department, departmentCompanyId);
            modelAndView.setViewName("department.html");
            return modelAndView;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/checkDepartmentName")
    public @ResponseBody
    String checkDepartmentName(@RequestParam String departmentName) {
        try {
            return departmentServiceImpl.findIdByDepartmentName(departmentName.trim().toLowerCase()).toUpperCase();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/getAllDepartmentByCompanyId")
    public @ResponseBody
    List<Department> getAllDepartmentByCompanyId(@RequestParam String companyId) {
        try {
            return companyServiceImpl.getAllDepartmentByCompanyId(companyId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/getAllDepartment")
    public @ResponseBody
    List<Department> getAllDepartment() {
        try {
            return  departmentServiceImpl.getAllDepartment();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/displayAllDepartment")
    public ModelAndView displayAllDepartment(ModelAndView modelAndView) {
        modelAndView.setViewName("departmentDisplay.html");
        return modelAndView;
    }
    @GetMapping("/isDepartmentIdAvailable")
    public @ResponseBody String isDepartmentIdAvailable(@RequestParam String departmentId,@RequestParam String departmentName){
       try{
        return departmentServiceImpl.isDepartmentIdAvailable(departmentId,departmentName);
    }
    catch(Exception e){
        System.out.println(e.getMessage());
        return null;
    }
    }
}
