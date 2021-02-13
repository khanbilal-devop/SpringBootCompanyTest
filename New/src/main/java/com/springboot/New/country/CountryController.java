/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.country;

import com.springboot.New.Json;
import com.springboot.New.state.State;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author oss
 */ 
@Controller
@RequestMapping("/country")
public class CountryController {
    
    @Autowired
    CountryServiceImpl countryServiceImpl;
    
    @PostMapping(value = "/checkCountryId", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<State> checkContryId(@RequestBody Json json) {
        try{
       return countryServiceImpl.checkCountryId(json.getAttribute());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
