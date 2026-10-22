package com.abes.hclhrms.repository;

import com.abes.hclhrms.entity.Employee;
import java.util.List;

public interface EmpRepo {
    String addemp(Employee emp);

    List<Employee> getEmp();

    Employee getEmpById(long emp_id);

    Employee deleteById(long emp_id);

    String updateById(long emp_id, Employee updateEmp);

    // Add employees in bulk
    String addEmpBulk(List<Employee> employees);
}