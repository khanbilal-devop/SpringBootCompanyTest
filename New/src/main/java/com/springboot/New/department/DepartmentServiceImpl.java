/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.department;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author oss
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentDaoImpl departmentDaoImpl;

    @Override
    public void saveDepartment(Department department, String departmentCompanyId) {
        departmentDaoImpl.saveDepartment(department, departmentCompanyId);

    }

    @Override
    public String findIdByDepartmentName(String departmentName) {
        return departmentDaoImpl.findIdByDepartmentName(departmentName);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentDaoImpl.getAllDepartment();
    }

    public String isDepartmentIdAvailable(String departmentId,String departmentName){
          return departmentDaoImpl.isDepartmentIdAvailable(departmentId,departmentName);
    }

}
