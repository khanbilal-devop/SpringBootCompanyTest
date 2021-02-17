/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.country;

import com.springboot.New.state.State;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author oss
 */
@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryDao countryDao;

    @Override
    public void saveAllCountry() {
        countryDao.saveAllCountry(this.createCountry());
    }

    @Override
    public List<Country> getAllCountry() {
        try {
            return countryDao.getAllCountry();
        } catch (Exception e) {
            System.out.println("Exception in [CountryServiceImpl]..[getAllCountry] " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<State> checkCountryId(String countryId) {
        try {
            return countryDao.checkCountryId(countryId);
        } catch (Exception e) {
            System.out.println("Exception in [CountryServiceImpl]..[checkCountryId] " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public List<Country> createCountry() {
        try {
            List<State> indianStateList = new ArrayList<State>();
            indianStateList.add(new State("SI-001", "Maharashtra"));
            indianStateList.add(new State("SI-002", "Uttar-Pradesh"));
            indianStateList.add(new State("SI-003", "Telangana"));
            List<State> americanStateList = new ArrayList<State>();
            americanStateList.add(new State("SA-001", "California"));
            americanStateList.add(new State("SA-002", "Florida"));
            americanStateList.add(new State("SA-003", "Texas"));
            List<State> germanStateList = new ArrayList<State>();
            germanStateList.add(new State("SG-001", "Hessen"));
            germanStateList.add(new State("SG-002", "Hamburg"));
            germanStateList.add(new State("SG-003", "Bremen"));
            List<Country> countryList = new ArrayList<Country>();
            countryList.add(new Country("C-001", "India", indianStateList));
            countryList.add(new Country("C-002", "Usa", americanStateList));
            countryList.add(new Country("C-003", "Germany", germanStateList));
            return countryList;
        } catch (Exception e) {
            System.out.println("Exception in [CountryServiceImpl]..[createCountry] " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

}
