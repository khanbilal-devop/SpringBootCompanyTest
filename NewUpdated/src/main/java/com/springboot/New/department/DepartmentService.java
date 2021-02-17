/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.department;

import java.util.List;

/**
 *
 * @author oss
 */
public interface DepartmentService {

    public void saveDepartment(Department department, String departmentCompanyId);

    public String findIdByDepartmentName(String departmentName);

    public List<Department> getAllDepartment();

    public String isDepartmentIdAvailable(String departmentId,String departmentName);

    public void deleteDepartment(String departmentId);
    
    public void savingNew(Department department);

}
