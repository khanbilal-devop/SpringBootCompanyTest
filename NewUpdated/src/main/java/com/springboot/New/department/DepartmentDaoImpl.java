/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.department;

import com.springboot.New.comapny.Company;
import com.springboot.New.comapny.CompanyCrud;
import com.springboot.New.employee.EmployeeCrud;
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

    @Autowired
    CompanyCrud companyCrud;
    @Autowired
    DepartmentCrud departmentCrud;
    @Autowired
    EmployeeCrud employeeCrud;

    @Override
    public void saveDepartment(Department department, String departmentCompanyId) {
        try {
            Company company = companyCrud.getOne(departmentCompanyId);
            company.getCompanyDepartmentList().add(department);
            departmentCrud.save(department);
            companyCrud.save(company);
        } catch (Exception e) {
            System.out.println("Exception in [DepartmentDaoImpl]..[saveDepartment] " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public String findIdByDepartmentName(String departmentName) {
        try {
            List<Department> departmentList = departmentCrud.findBydepartmentName(departmentName);
            if (departmentList.isEmpty()) {
                return "Not Found";
            } else {
                return departmentList.get(0).getDepartmentId();
            }
        } catch (Exception e) {
            System.out.println("Exception in [DepartmentDaoImpl]..[findIdByDepartmentName] " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Department> getAllDepartment() {
        try {
            return departmentCrud.findAll();
        } catch (Exception e) {
            System.out.println("Exception in [DepartmentDaoImpl]..[getAllDepartment] " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public String isDepartmentIdAvailable(String departmentId, String departmentName) {

        try {
            try {
                Department department = departmentCrud.getOne(departmentId);
                System.out.println(department);
                if (department.getDepartmentName().equals(departmentName)) {
                    return "No";
                }
                return "Yes";
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return "No";
            }
        } catch (Exception e) {
            System.out.println("Exception in [DepartmentDaoImpl]..[isDepartmentIdAvailable] " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteDepartment(String departmentId) {
        try {
            String companyId = "";
            List<Company> companyList = companyCrud.findAll();
            for (Company company : companyList) {
                List<Department> departmentList = company.getCompanyDepartmentList();
                for (Department department : departmentList) {
                    if (department.getDepartmentId().equals(departmentId)) {
                        companyId = company.getCompanyId();
                    }
                }
            }
            Company company = companyCrud.getOne(companyId);
            company.getCompanyDepartmentList().remove(departmentCrud.getOne(departmentId));
            System.out.println(company.getCompanyDepartmentList());
            companyCrud.save(company);
            employeeCrud.deleteAll(employeeCrud.findByEmployeeDepartmentId(departmentId));
            departmentCrud.deleteById(departmentId);
        } catch (Exception e) {
            System.out.println("Exception in [DepartmentDaoImpl]..[deleteDepartment] " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void savingNew(Department department) {
        try {
            String departmentId = department.getDepartmentId();
            String companyId = "";
            List<Company> companyList = companyCrud.findAll();
            for (Company company : companyList) {
                for (Department departmen : company.getCompanyDepartmentList()) {
                    if (departmen.getDepartmentId().equals(departmentId)) {
                        companyId = company.getCompanyId();
                        break;
                    }
                }
            }
            List<Department> departmentList = companyCrud.getOne(companyId).getCompanyDepartmentList();
            for (Department departmen : departmentList) {
                if (departmen.getDepartmentId().equals(departmentId)) {
                    departmentList.remove(departmen);
                    departmentList.add(department);
                    Company company = companyCrud.getOne(companyId);
                    company.setCompanyDepartmentList(departmentList);
                    companyCrud.save(company);
                    departmentCrud.save(department);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in [DepartmentDaoImpl]..[savingNew] " + e.getMessage());
            e.printStackTrace();
        }
    }
}
