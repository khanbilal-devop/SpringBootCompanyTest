/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.department;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author oss
 */ 
@Entity
public class Department {
    
    @Id
    private String departmentId;
    private String departmentName;

    public Department() {
    }

    public Department(String departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    @Override
    public String toString() {
        return "Department{" + "departmentId=" + departmentId + ", departmentName=" + departmentName + '}';
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
}
