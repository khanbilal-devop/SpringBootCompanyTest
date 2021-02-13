/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.state;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author oss
 */
@Entity
public class State {
    
    @Id
    private String stateId;
    private String stateName;

    public State(String stateId, String stateName) {
        this.stateId = stateId;
        this.stateName = stateName;
    }

    public State() {
    }

    public String getstateId() {
        return stateId;
    }

    public void setstateId(String stateId) {
        this.stateId = stateId;
    }

    public String getstateName() {
        return stateName;
    }

    public void setstateName(String stateName) {
        this.stateName = stateName;
    }

    @Override
    public String toString() {
        return "State{" + "stateId=" + stateId + ", stateName=" + stateName + '}';
    }
    
    
}
