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
public interface DepartmentDao {
    
    public void save(Department department,String company);
    public String findIdByDepartmentName(String departmentName);
}
