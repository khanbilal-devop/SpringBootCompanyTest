/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.comapny;

import com.springboot.New.country.CountryCrud;
import com.springboot.New.department.Department;
import com.springboot.New.employee.EmployeeCrud;
import com.springboot.New.state.StateCrud;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author oss
 */
@Repository
public class CompanyDaoImpl implements CompanyDao {

    @Autowired
    CompanyCrud companyCrud;
    @Autowired
    CountryCrud countryCrud;
    @Autowired
    StateCrud stateCrud;
    @Autowired
    EmployeeCrud employeeCrud;

    /**
     *
     * @param company
     * @return
     */
    @Override
    public Company saveCompany(Company company) {
        try{
        return companyCrud.save(company);
                        }  catch(Exception e){
            System.out.println("Exception in [CompanyDaoImpl]..[saveCompany] "+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Company> getAllCompany() {
        try {
            return companyCrud.findAll();
        } catch (Exception e) {
            System.out.println("Exception in [CompanyDaoImpl]..[getAllCompany] " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Department> getAllDepartmentByCompanyId(String companyId) {
        try {
            Company company = companyCrud.getOne(companyId);
            return company.getCompanyDepartmentList();
        } catch (Exception e) {
            System.out.println("Exception in [CompanyDaoImpl]..[getAllDepartmentByCompanyId] " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String checkCompanyName(String companyName) {
        try {
            List<Company> companyList = companyCrud.findByCompanyName(companyName);
            if (companyList.isEmpty()) {
                return "Not Found";
            }
            return companyList.get(0).getCompanyId();
        } catch (Exception e) {
            System.out.println("Exception in [CompanyDaoImpl]..[checkCompanyname] " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String isCompanyIdAvailable(String companyId, String companyName) {
        try {
            try {
                Company company = companyCrud.getOne(companyId);
                System.out.println(company);
                if (company.getCompanyName().equals(companyName)) {
                    return "No";
                }
                return "Yes";
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return "No";
            }
        } catch (Exception e) {
            System.out.println("Exception in [CompanyDaoImpl]..[isCompanyIdAvailable] " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteCompany(String companyId) {
        try {
            employeeCrud.deleteAll(employeeCrud.findByEmployeeCompanyId(companyId));
            companyCrud.deleteById(companyId);
        } catch (Exception e) {
            System.out.println("Exception in [CompanyDaoImpl]..[deleteCompany] " + e.getMessage());
            e.printStackTrace();
        }
    }

}
