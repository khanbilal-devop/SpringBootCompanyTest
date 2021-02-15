/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.department;

import com.springboot.New.comapny.Company;
import com.springboot.New.comapny.CompanyCrud;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author oss
 */
@Repository
public class DepartmentDaoImpl implements DepartmentDao {

    static List<Department> ld = new ArrayList<>();

    @Autowired
    CompanyCrud companyCrud;
    @Autowired
    DepartmentCrud departmentCrud;

    @Override
    public void saveDepartment(Department department, String departmentCompanyId) {
        Company company = companyCrud.getOne(departmentCompanyId);
        company.getCompanyDepartmentList().add(department);
        companyCrud.save(company);
    }

    @Override
    public String findIdByDepartmentName(String departmentName) {
        List<Department> departmentList = departmentCrud.findBydepartmentName(departmentName);
        if (departmentList.isEmpty()) {
            return "Not Found";
        } else {
            return departmentList.get(0).getDepartmentId();
        }
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentCrud.findAll();
    }

    public String isDepartmentIdAvailable(String departmentId,String departmentName) {
        try{ Department department = departmentCrud.getOne(departmentId);
             System.out.println(department);
             if(department.getDepartmentName().equals(departmentName))
                   return "No";
              return "Yes";
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "No";
        }
    }
}