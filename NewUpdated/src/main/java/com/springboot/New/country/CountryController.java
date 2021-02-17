/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.country;

import com.springboot.New.state.State;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author oss
 */
@Controller
@RequestMapping("/country")
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping("/checkCountryId")
    public @ResponseBody
    List<State> checkContryId(@RequestParam String countryId) {
        try {
            return countryService.checkCountryId(countryId);
        } catch (Exception e) {
            System.out.println("Exception in [CountryController]..[checkCountryId] " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
