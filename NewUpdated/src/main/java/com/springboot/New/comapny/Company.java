/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.comapny;

import com.springboot.New.department.Department;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

@Entity
public class Company {

    @Id
    private String companyId;
    private String companyName;
    private String gstCompliant;
    private String companyCountryId;
    private String companyStateId;
    private String companyWebsite;
    @Lob
    private byte[] companyCertificate;
    @ManyToMany
    private List<Department> companyDepartmentList;

    public Company() {
    }

    public Company(String companyId, String companyName, String gstCompliant, String companyCountryId, String companyStateId, byte[] companyCertificate, List<Department> companyDepartmentList,String companyWebsite) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.gstCompliant = gstCompliant;
        this.companyCountryId = companyCountryId;
        this.companyStateId = companyStateId;
        this.companyCertificate = companyCertificate;
        this.companyDepartmentList = companyDepartmentList;
        this.companyWebsite = companyWebsite;
    }

    @Override
    public String toString() {
        return "Company{" + "companyId=" + companyId + ", companyName=" + companyName + ", gstCompliant=" + gstCompliant + ", companyCountryId=" + companyCountryId + ", companyStateId=" + companyStateId + ", companyCertificate=" + companyCertificate + ", companyDepartmentList=" + companyDepartmentList + '}';
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyId() {
        return this.companyId;
    }

    public List<Department> getCompanyDepartmentList() {
        return companyDepartmentList;
    }

    public void setCompanyDepartmentList(List<Department> companyDepartmentList) {
        this.companyDepartmentList = companyDepartmentList;
    }

    public String getGstCompliant() {
        return gstCompliant;
    }

    public void setGstCompliant(String gstCompliant) {
        this.gstCompliant = gstCompliant;
    }

    public String getCompanyCountryId() {
        return companyCountryId;
    }

    public void setCompanyCountryId(String companyCountryId) {
        this.companyCountryId = companyCountryId;
    }

    public String getCompanyStateId() {
        return companyStateId;
    }

    public void setCompanyStateId(String companyStateId) {
        this.companyStateId = companyStateId;
    }

    public byte[] getCompanyCertificate() {
        return companyCertificate;
    }

    public void setCompanyCertificate(byte[] companyCertificate) {
        this.companyCertificate = companyCertificate;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }
    

}
