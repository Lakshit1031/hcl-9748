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
    public String welcomeMsg(){
        return "Welcome to ABES HRMS";
    }
    @GetMapping("/addemp")
    public String addnewEmployee(){
        return employeeServiceImp.addEmp();
    }
    @GetMapping("/getemp")
    public List<Employee> getEmp(){
        return employeeServiceImp.getEmp();
    }
    @GetMapping("/id")
    public Employee getempById(){
        return employeeServiceImp.getEmpId();
    }
    @GetMapping("/bulk")
    public String addEmpBulk(){
        return employeeServiceImp.addEmpBulk();
    }
    @DeleteMapping("/delete")
    public String deleteEmpById(){
        return employeeServiceImp.deleteEmpById();
    }
    @PutMapping("/update")
    public String updateById(){
        return employeeServiceImp.updateById();
    }
}