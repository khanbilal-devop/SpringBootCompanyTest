/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.employee;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author oss
 */
 
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Employee implements Serializable{

    @Id
    private String employeeId;
    private String employeeName;
    private String employeeCompanyId;
    private String employeeDepartmentId;
    private String employeeGender;
    private String employeeMailId;
    private String employeeHobby;

    public Employee() {
    }

    public Employee(String employeeId, String employeeName, String employeeCompanyId, String employeeDepartmentId, String employeeGender, String employeeMailId, String employeeHobby) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeCompanyId = employeeCompanyId;
        this.employeeDepartmentId = employeeDepartmentId;
        this.employeeGender = employeeGender;
        this.employeeMailId = employeeMailId;
        this.employeeHobby = employeeHobby;
    }
    
    
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeCompanyId() {
        return employeeCompanyId;
    }

    public void setEmployeeCompanyId(String employeeCompanyId) {
        this.employeeCompanyId = employeeCompanyId;
    }

    public String getEmployeeDepartmentId() {
        return employeeDepartmentId;
    }

    public void setEmployeeDepartmentId(String employeeDepartmentId) {
        this.employeeDepartmentId = employeeDepartmentId;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public String getEmployeeMailId() {
        return employeeMailId;
    }

    public void setEmployeeMailId(String employeeMailId) {
        this.employeeMailId = employeeMailId;
    }

    public String getEmployeeHobby() {
        return employeeHobby;
    }

    public void setEmployeeHobby(String employeeHobby) {
        this.employeeHobby = employeeHobby;
    }



}
