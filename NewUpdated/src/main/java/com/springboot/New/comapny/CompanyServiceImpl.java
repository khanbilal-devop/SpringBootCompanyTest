/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.comapny;

import com.springboot.New.department.Department;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author oss
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyDao companyDao;

    @Override
    public Company saveCompany(Company company) {
        try {
            return companyDao.saveCompany(company);
        } catch (Exception e) {
            System.out.println("Exception in [CompanyServiceImpl]..[saveCompany] " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Company> getAllCompany() {
        try {
            return companyDao.getAllCompany();
        } catch (Exception e) {
            System.out.println("Exception in [CompanyServiceImpl]..[getAllCompany] " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Department> getAllDepartmentByCompanyId(String companyId) {
        try {
            return companyDao.getAllDepartmentByCompanyId(companyId);
        } catch (Exception e) {
            System.out.println("Exception in [CompanyServiceImpl]..[getAllDepartmentByCompanyId] " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String checkCompanyName(String companyName) {
        try {
            return companyDao.checkCompanyName(companyName);
        } catch (Exception e) {
            System.out.println("Exception in [CompanyServiceImpl]..[checkCompanyName] " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String isCompanyIdAvailable(String companyId, String companyName) {
        try {
            return companyDao.isCompanyIdAvailable(companyId, companyName);
        } catch (Exception e) {
            System.out.println("Exception in [CompanyServiceImpl]..[isCompanyIdAvailable] " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteCompany(String companyId) {
        try{
        companyDao.deleteCompany(companyId);
         }  catch(Exception e){
            System.out.println("Exception in [CompanyServiceImpl]..[deleteCompany] "+e.getMessage());
            e.printStackTrace();
        }
    }

}
