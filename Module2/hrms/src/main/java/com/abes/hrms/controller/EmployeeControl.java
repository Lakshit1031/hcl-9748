package com.abes.hrms.controller;


import com.abes.hrms.model.demoEmployee;
import com.abes.hrms.repository.EmpRepo;
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
        int result = demoEmployee.add();
        System.out.println("Result of addition is: " + result);
        return result;
    }

    @GetMapping("/squareroot")
    public double squareRoot(){
        System.out.println("Inside /squareroot controller point");
        double result = demoEmployee.squareRoot();
        System.out.println("Result of square root is: " + result);
        return result;
    }

    @GetMapping("/gtn")
    public int gtn(){
        System.out.println("Inside /gtn controller point");
        int result = demoEmployee.gtn();
        System.out.println("Result of greater than is: " + result);
        return result;
    }
}
