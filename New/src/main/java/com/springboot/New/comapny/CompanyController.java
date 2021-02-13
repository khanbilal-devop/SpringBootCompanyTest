/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.comapny;

import com.springboot.New.*;
import com.springboot.New.country.CountryServiceImpl;
import com.springboot.New.department.Department;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author oss
 */
@org.springframework.stereotype.Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyServiceImpl companyServiceImpl;
    @Autowired
    CountryServiceImpl countryServiceImpl;
    
    static Company company = new Company();
    
    @GetMapping("/register")
    public ModelAndView companyRegister(ModelAndView modelAndView) {
        try{
        countryServiceImpl.saveAllCountry();
        modelAndView.setViewName("company.html");
        return modelAndView;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/saving")
    public ModelAndView saveCompany(ModelAndView modelAndView,Company company,@RequestParam MultipartFile companyCertificateReal){//@RequestParam("companyCertificate") MultipartFile companyCertificate,@RequestParam ("companyId") String companyId,@RequestParam("companyName") String companyName,@RequestParam("companyCountryId") String companyCountryId,@RequestParam("companyStateId") String companyStateId,@RequestParam("gstCompliant") String gstCompliant, ModelAndView modelAndView) {
        try {
            company.setCompanyCertificate(companyCertificateReal.getBytes());
            companyServiceImpl.save(company);
            modelAndView.setViewName("company.html");
            return modelAndView;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/checkCompanyName")
    public @ResponseBody String checkCompanyName(@RequestBody Json json) {
      try{ return  companyServiceImpl.checkCompanyName(json.getAttribute().trim().toLowerCase()).toUpperCase();
    }   
    catch(Exception e){
            System.out.println(e.getMessage());
            return null;
     }
    }
  
    @PostMapping(value = "/loadAllCompany", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Company> loadAllCompany(@RequestBody Json json) {
     try{   
        List<Company> allCompanyList = companyServiceImpl.getAllCompany();
        return allCompanyList;
     }
     catch(Exception e ){
         System.out.println(e.getMessage());
         return null;
     }
    }


}
