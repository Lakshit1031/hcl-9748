package com.abes.hclhrms;

import com.abes.hclhrms.entity.Employee;
import com.abes.hclhrms.repository.EmpRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp {

    @Autowired
    private EmpRepoImp empRepo;

    public String addEmp() {
        Employee emp = new Employee(
                101L,
                "John Doe",
                "FSD",
                "Java",
                "john.doe@example.com"
        );

        return empRepo.addemp(emp);
    }

    public List<Employee> getEmp() {
        return empRepo.getEmp();
    }

    // Get employee by ID
    public Employee getEmpById(long emp_id) {
        return empRepo.getEmpById(emp_id);
    }

    // Add employees in bulk
    public String addEmpBulk(List<Employee> employees) {
        return empRepo.addEmpBulk(employees);
    }
}