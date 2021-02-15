/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.comapny;

import com.springboot.New.country.CountryServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

/**
 *
 * @author oss
 */
@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyServiceImpl companyServiceImpl;
    @Autowired
    CountryServiceImpl countryServiceImpl;



    @GetMapping("/register")
    public ModelAndView companyRegister(ModelAndView modelAndView) {
        try {
            countryServiceImpl.saveAllCountry();
            modelAndView.setViewName("company.html");
            return modelAndView;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/saving")
    public ModelAndView saveCompany(ModelAndView modelAndView, Company company, @RequestParam MultipartFile companyCertificateReal) {
        try {
            company.setCompanyCertificate(companyCertificateReal.getBytes());
            companyServiceImpl.saveCompany(company);
            modelAndView.setViewName("company.html");
            return modelAndView;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/checkCompanyName")
    public @ResponseBody
    String checkCompanyName(@RequestParam String companyName) {
        try {
            return companyServiceImpl.checkCompanyName(companyName.trim().toLowerCase()).toUpperCase();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/getAllCompany")
    public @ResponseBody
    List<Company> getAllCompany() {
        try {
           return companyServiceImpl.getAllCompany();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/displayAllCompany")
    public ModelAndView displayAllCompany(ModelAndView modelAndView) {
        modelAndView.setViewName("companyDisplay.html");
        return modelAndView;
    }
    
    @GetMapping("/isCompanyIdAvailable")
    public @ResponseBody String isCompanyIdAvailable(@RequestParam String companyId,@RequestParam String companyName){
       return companyServiceImpl.isCompanyIdAvailable(companyId,companyName);
    }

}
