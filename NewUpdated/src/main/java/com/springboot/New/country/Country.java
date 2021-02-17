/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.country;

import com.springboot.New.state.State;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author oss
 */
@Entity
public class Country {

    @Id
    private String countryId;
    private String countryName;
    @OneToMany(cascade = CascadeType.ALL)
    private List<State> countryStateList;

    public Country() {
    }

    public Country(String countryId, String countryName, List<State> countryStateList) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.countryStateList = countryStateList;
    }

    @Override
    public String toString() {
        return "Country{" + "countryId=" + countryId + ", countryName=" + countryName + ", countryStateList=" + countryStateList + '}';
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public List<State> getCountryStateList() {
        return countryStateList;
    }

    public void setCountryStateList(List<State> countryStateList) {
        this.countryStateList = countryStateList;
    }

}
