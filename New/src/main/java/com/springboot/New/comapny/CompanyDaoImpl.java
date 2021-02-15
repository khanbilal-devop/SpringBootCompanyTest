/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.comapny;

import com.springboot.New.department.Department;
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
    private CompanyCrud companyCrud;

    /**
     *
     * @param company
     * @return
     */
    @Override
    public Company saveCompany(Company company) {
        return companyCrud.save(company);
    }

    @Override
    public List<Company> getAllCompany() {
        return companyCrud.findAll();
    }

    @Override
    public List<Department> getAllDepartmentByCompanyId(String companyId) {
        Company company = companyCrud.getOne(companyId);
        return company.getCompanyDepartmentList();
    }

    @Override
    public String checkCompanyName(String companyName) {
        List<Company> companyList = companyCrud.findByCompanyName(companyName);
        if (companyList.isEmpty()) {
            return "Not Found";
        }
        return companyList.get(0).getCompanyId();
    }

    @Override
    public String isCompanyIdAvailable(String companyId,String companyName) {
        try{
           Company company = companyCrud.getOne(companyId);
            System.out.println(company);
            if(company.getCompanyName().equals(companyName))
                return "No";
              return "Yes";
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "No";
        }
    }

}
