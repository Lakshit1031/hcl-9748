package com.abes.hrms.controller;


import com.abes.hrms.model.demoEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeControl {
    @Autowired
    private demoEmployee demoEmployee;


    @GetMapping("/")
    public String welcome() {
        return "<h2 style='color:red'>  Welcome to HRMS Application</h2>" + "";
    }

    @GetMapping("/add")
    public int sum(){
        System.out.println("Inside /add controller point");
        int result = demoEmployee.add(20, 50);
        System.out.println("Result of addition is: " + result);
        return result;
    }
}
