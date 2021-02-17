/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.country;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author oss
 */
@Repository
public interface CountryCrud extends JpaRepository<Country, String> {

    public List<Country> findCountryStateListByCountryId(String countryId);
}
