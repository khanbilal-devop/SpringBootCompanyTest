
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
