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
    CountryDaoImpl countryDaoImpl;

    @Override
    public void saveAllCountry() {
        countryDaoImpl.saveAllCountry(this.createCountry());
    }

    @Override
    public List<Country> getAllCountry() {
        return countryDaoImpl.getAllCountry();
    }

    @Override
    public List<State> checkCountryId(String countryId) {
        return countryDaoImpl.checkCountryId(countryId);
    }

    public List<Country> createCountry() {
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
    }

}
