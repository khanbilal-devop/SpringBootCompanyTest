/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New;

import com.springboot.New.comapny.Company;
import com.springboot.New.comapny.CompanyCrud;
import com.springboot.New.comapny.CompanyServiceImpl;
import com.springboot.New.country.Country;
import com.springboot.New.country.CountryServiceImpl;
import com.springboot.New.department.Department;
import com.springboot.New.department.DepartmentServiceImpl;
import com.springboot.New.employee.Employee;
import com.springboot.New.employee.EmployeeServiceImpl;
import com.springboot.New.state.State;
import com.springboot.New.state.StateServiceImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@org.springframework.stereotype.Controller
@RequestMapping("/controller")
public class Controller {


    @GetMapping("/home")
    public ModelAndView home(ModelAndView modelAndView) {
        modelAndView.setViewName("home.html");
        return modelAndView;
    }
}
