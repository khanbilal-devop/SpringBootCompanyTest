/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.comapny;

import com.springboot.New.*;
import com.springboot.New.department.Department;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;

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
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Department> companyDepartmentList;

    public Company() {
    }

    public Company(String companyId, String companyName, String gstCompliant, String companyCountryId, String companyStateId, byte[] companyCertificate, List<Department> companyDepartmentList) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.gstCompliant = gstCompliant;
        this.companyCountryId = companyCountryId;
        this.companyStateId = companyStateId;
        this.companyCertificate = companyCertificate;
        this.companyDepartmentList = companyDepartmentList;
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

}
