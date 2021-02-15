/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.comapny;

import com.springboot.New.department.Department;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 *
 * @author oss
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyDaoImpl companyDaoImpl;
    

    @Override
    public Company saveCompany(Company company) {
        return companyDaoImpl.saveCompany(company);
    }

    @Override
    public List<Company> getAllCompany() {
        return companyDaoImpl.getAllCompany();
    }

    @Override
    public List<Department> getAllDepartmentByCompanyId(String companyId) {
        return companyDaoImpl.getAllDepartmentByCompanyId(companyId);
    }

    @Override
    public String checkCompanyName(String companyName) {
        return companyDaoImpl.checkCompanyName(companyName);
    }

    @Override
    public String isCompanyIdAvailable(String companyId,String companyName) {
       return companyDaoImpl.isCompanyIdAvailable(companyId,companyName);
    }

}
