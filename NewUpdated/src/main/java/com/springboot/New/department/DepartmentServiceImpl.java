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
    DepartmentDao departmentDao;

    @Override
    public void saveDepartment(Department department, String departmentCompanyId) {
        try {
            departmentDao.saveDepartment(department, departmentCompanyId);
        } catch (Exception e) {
            System.out.println("Exception in [DepartmentServiceImpl]..[saveDepartment] " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public String findIdByDepartmentName(String departmentName) {
        try {
            return departmentDao.findIdByDepartmentName(departmentName);
        } catch (Exception e) {
            System.out.println("Exception in [DepartmentServiceImpl]..[findIdByDepartmentName] " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Department> getAllDepartment() {
        try {
            return departmentDao.getAllDepartment();
        } catch (Exception e) {
            System.out.println("Exception in [DepartmentServiceImpl]..[getAllDepartment] " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public String isDepartmentIdAvailable(String departmentId, String departmentName) {
        try {
            return departmentDao.isDepartmentIdAvailable(departmentId, departmentName);
        } catch (Exception e) {
            System.out.println("Exception in [DepartmentServiceImpl]..[isDepartmentIdAvailable] " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteDepartment(String departmentId) {
        try {
            departmentDao.deleteDepartment(departmentId);
        } catch (Exception e) {
            System.out.println("Exception in [DepartmentServiceImpl]..[deleteDepartment] " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void savingNew(Department department) {
        try {
            departmentDao.savingNew(department);
        } catch (Exception e) {
            System.out.println("Exception in [DepartmentServiceImpl]..[savingNew] " + e.getMessage());
            e.printStackTrace();
        }
    }

}
