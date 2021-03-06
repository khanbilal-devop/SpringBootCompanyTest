/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.New.employee;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author oss
 */ 
@Repository
public interface EmployeeCrud extends JpaRepository<Employee, String>{
    
    public List<Employee> findByEmployeeName(String employeeName);
    
    public List<Employee> findByEmployeeCompanyId(String employeeCompanyId);
    
     public List<Employee> findByEmployeeDepartmentId(String employeeDepartmentId);
    
}
