/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.comapny;

import com.springboot.New.department.Department;
import java.util.List;

/**
 *
 * @author oss
 */
public interface CompanyService {

    public Company saveCompany(Company company);

    public List<Company> getAllCompany();

    public List<Department> getAllDepartmentByCompanyId(String companyId);

    public String checkCompanyName(String companyName);
    
    public String isCompanyIdAvailable(String companyId,String companyName);
    
    public void deleteCompany(String companyId);
}
