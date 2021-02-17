/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.comapny;

import com.springboot.New.country.CountryService;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author oss
 */
@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;
    @Autowired
    CountryService countryService;
    static String companyId;

    @GetMapping("/register")
    public ModelAndView companyRegister(ModelAndView modelAndView) {
        try {
            countryService.saveAllCountry();
            modelAndView.setViewName("company.html");
            return modelAndView;
        } catch (Exception e) {
            System.out.println("Exception in [CompanyController]..[companyRegister] " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/saving")
    public ModelAndView saveCompany(ModelAndView modelAndView, Company company, @RequestParam MultipartFile companyCertificateReal) {
        try {
            company.setCompanyCertificate(companyCertificateReal.getBytes());
            companyService.saveCompany(company);
            modelAndView.setViewName("success.html");
            return modelAndView;
        } catch (Exception e) {
            System.out.println("Exception in [CompanyController]..[saving] " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/checkCompanyName")
    public @ResponseBody
    String checkCompanyName(@RequestParam String companyName) {
        try {
            return companyService.checkCompanyName(companyName.trim().toLowerCase()).toUpperCase();
        } catch (Exception e) {
            System.out.println("Exception in [CompanyController]..[checkCompanyName] " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/getAllCompany")
    public @ResponseBody
    List<Company> getAllCompany() {
        try {
            return companyService.getAllCompany();
        } catch (Exception e) {
            System.out.println("Exception in [CompanyController]..[getAllCompany] " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/displayAllCompany")
    public ModelAndView displayAllCompany(ModelAndView modelAndView) {
        modelAndView.setViewName("companyDisplay.html");
        return modelAndView;
    }

    @GetMapping("/isCompanyIdAvailable")
    public @ResponseBody
    String isCompanyIdAvailable(@RequestParam String companyId, @RequestParam String companyName) {
        try {
            return companyService.isCompanyIdAvailable(companyId, companyName);
        } catch (Exception e) {
            System.out.println("Exception in [CompanyController]..[isCompanyIdAvailable] " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping("/deleteCompany/{companyIdDelete}")
    public ModelAndView deleteCompany(@PathVariable String companyIdDelete, ModelAndView modelAndView) {
        try {
            companyService.deleteCompany(companyIdDelete);
            modelAndView.setViewName("changes.html");
            return modelAndView;
        } catch (Exception e) {
            System.out.println("Exception in [CompanyController]..[deleteCompany] " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/editCompanyView")
    public ModelAndView editCompanyView(@RequestParam String companyIdEdit, ModelAndView modelAndView) {
        companyId = companyIdEdit;
        modelAndView.setViewName("companyUpdate.html");
        return modelAndView;
    }

    @GetMapping("/getCompanyId")
    public @ResponseBody
    String getCompanyId() {
        return companyId;
    }

    @PostMapping("/savingNew")
    public ModelAndView savingNew(Company company, ModelAndView modelAndView) {
        try {
            companyService.saveCompany(company);
            modelAndView.setViewName("changes.html");
            return modelAndView;
        } catch (Exception e) {
            System.out.println("Exception in [CompanyController]..[savingNew] " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
