package com.abes.hrmsdatabase.controller;

import com.abes.hrmsdatabase.model.Employee;
import com.abes.hrmsdatabase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String msg(){
        return "<h2>Welcome to Springboot HRMS Database Application</h2>";
    }

    @GetMapping("/create")
    public String addnewEmployee() {
        return employeeService.createnewEmployee();
    }

    @GetMapping("findbyid/{emp_id}")
    public Employee getEmpByEmpId(@PathVariable long emp_id) {
        System.out.println(emp_id);
        return employeeService.getEmployeeById(emp_id);
    }

    @DeleteMapping("delete/{emp_id}")
    public String deleteEmployee(@PathVariable long emp_id) {
        return employeeService.deleteById(emp_id);
    }

    @PutMapping("update/{emp_id}")
    public String updateById(@PathVariable long emp_id) {
        return employeeService.updateById(emp_id);
    }
}
