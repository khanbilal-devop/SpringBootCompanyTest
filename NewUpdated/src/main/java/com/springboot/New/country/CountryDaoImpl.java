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
public class CountryDaoImpl implements CountryDao {

    @Autowired
    CountryCrud countryCrud;

    public void saveAllCountry(List<Country> countryList) {
        try {
            countryCrud.saveAll(countryList);
        } catch (Exception e) {
            System.out.println("Exception in [CountryDaoImpl]..[saveAllCountry] " + e.getMessage());
            e.printStackTrace();

        }
    }

    @Override
    public List<Country> getAllCountry() {
        try {
            return countryCrud.findAll();
        } catch (Exception e) {
            System.out.println("Exception in [CountryDaoImpl]..[getAllCountry] " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<State> checkCountryId(String countryId) {
        try {
            return countryCrud.findCountryStateListByCountryId(countryId).get(0).getCountryStateList();
        } catch (Exception e) {
            System.out.println("Exception in [CountryDaoImpl]..[checkCountryId] " + e.getMessage());
            e.printStackTrace();
            return null;
        }

    }

}
