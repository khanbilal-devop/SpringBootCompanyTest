/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.country;

import com.springboot.New.state.State;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author oss
 */ 
@Repository
public class CountryDaoImpl implements CountryDao{
    
    @Autowired
    CountryCrud countryCrud;
    
    public void saveAllCountry(List<Country> countryList){
       countryCrud.saveAll(countryList);
    }

    @Override
    public List<Country> getAllCountry() {
        return countryCrud.findAll();
    }

    @Override
    public List<State> checkCountryId(String countryId) {
      return  countryCrud.findCountryStateListByCountryId(countryId).get(0).getCountryStateList();
    }
    
}
