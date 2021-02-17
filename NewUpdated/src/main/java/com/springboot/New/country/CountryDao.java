/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.country;

import com.springboot.New.state.State;
import java.util.List;

/**
 *
 * @author oss
 */
public interface CountryDao {

    public List<Country> getAllCountry();

    public void saveAllCountry(List<Country> countryList);

    public List<State> checkCountryId(String countryId);

}
