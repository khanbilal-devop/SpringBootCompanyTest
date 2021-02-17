/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.department;

import com.springboot.New.employee.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author oss
 */
@Repository
public interface DepartmentCrud extends JpaRepository<Department, String> {

    public List<Department> findBydepartmentName(String departmentName);
    
   
}