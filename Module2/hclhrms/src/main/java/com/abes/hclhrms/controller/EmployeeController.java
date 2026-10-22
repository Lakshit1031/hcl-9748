package com.abes.hclhrms.controller;

import com.abes.hclhrms.EmployeeServiceImp;
import com.abes.hclhrms.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServiceImp employeeServiceImp;

    @GetMapping("/")
    public String welcome() {
        return "<h2 style='color:red'>Welcome to HRMS Application</h2>";
    }

    @GetMapping("/addemp")
    public String addemp() {
        return employeeServiceImp.addEmp();
    }

    @GetMapping("/getemp")
    public List<Employee> getemp() {
        return employeeServiceImp.getEmp();
    }

    // Get employee by ID
    @GetMapping("/getemp/{id}")
    public Employee getEmpById(@PathVariable("id") long emp_id) {
        return employeeServiceImp.getEmpById(emp_id);
    }

    // Add employees in bulk
    @PostMapping("/addemp/bulk")
    public String addEmpBulk(@RequestBody List<Employee> employees) {
        return employeeServiceImp.addEmpBulk(employees);
    }
}