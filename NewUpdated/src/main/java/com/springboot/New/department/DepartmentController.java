/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.department;

import com.springboot.New.comapny.CompanyService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;
    @Autowired
    CompanyService companyService;

    static String departmentId;

    @GetMapping("/register")
    public ModelAndView departmentRegister(ModelAndView modelAndView) {
        modelAndView.setViewName("department.html");
        return modelAndView;
    }

    @PostMapping("/saving")
    public ModelAndView saveDepartment(Department department, ModelAndView modelAndView, @RequestParam String departmentCompanyId) {
        try {
            departmentService.saveDepartment(department, departmentCompanyId);
            modelAndView.setViewName("success.html");
            return modelAndView;
        } catch(Exception e){
            System.out.println("Exception in [DepartmentController]..[saving] "+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/checkDepartmentName")
    public @ResponseBody
    String checkDepartmentName(@RequestParam String departmentName) {
        try {
            return departmentService.findIdByDepartmentName(departmentName.trim().toLowerCase()).toUpperCase();
        } catch(Exception e){
            System.out.println("Exception in [DepartmentController]..[checkDepartmentName] "+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/getAllDepartmentByCompanyId")
    public @ResponseBody
    List<Department> getAllDepartmentByCompanyId(@RequestParam String companyId) {
        try {
            return companyService.getAllDepartmentByCompanyId(companyId);
        } catch(Exception e){
            System.out.println("Exception in [DepartmentController]..[getAllDepartmentByCompanyId] "+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/getAllDepartment")
    public @ResponseBody
    List<Department> getAllDepartment() {
        try {
            return departmentService.getAllDepartment();
        } catch(Exception e){
            System.out.println("Exception in [DepartmentController]..[getAllDepartment] "+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/displayAllDepartment")
    public ModelAndView displayAllDepartment(ModelAndView modelAndView) {
        modelAndView.setViewName("departmentDisplay.html");
        return modelAndView;
    }

    @GetMapping("/isDepartmentIdAvailable")
    public @ResponseBody
    String isDepartmentIdAvailable(@RequestParam String departmentId, @RequestParam String departmentName) {
        try {
            return departmentService.isDepartmentIdAvailable(departmentId, departmentName);
        } catch (Exception e) {
            System.out.println("Exception in [DepartmentController]..[isDepartmentIdAvailable] " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping("/deleteDepartment/{departmentIdDelete}")
    public ModelAndView deleteDepartment(@PathVariable String departmentIdDelete, ModelAndView modelAndView) {
        try {
            departmentService.deleteDepartment(departmentIdDelete);
            modelAndView.setViewName("changes.html");
            return modelAndView;
        } catch (Exception e) {
            System.out.println("Exception in [DepartmentController]..[deleteDepartment] " + e.getMessage());
            e.printStackTrace();
            return null;
        }

    }

    @GetMapping("/editDepartmentView")
    public ModelAndView editCompany(@RequestParam String departmentIdEdit, ModelAndView modelAndView) {

        departmentId = departmentIdEdit;
        modelAndView.setViewName("departmentUpdate.html");
        return modelAndView;
    }

    @GetMapping("/getDepartmentId")
    public @ResponseBody
    String getDepartmentId() {
        return departmentId;
    }

    @PostMapping("/savingNew")
    public ModelAndView savingNew(Department department, ModelAndView modelAndView) {
        try {
            departmentService.savingNew(department);
            modelAndView.setViewName("changes.html");
            return modelAndView;
        } catch (Exception e) {
            System.out.println("Exception in [DepartmentController]..[savingNew] " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
