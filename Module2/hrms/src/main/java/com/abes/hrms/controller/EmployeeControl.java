package com.abes.hrms.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeControl {


    @GetMapping("/")
    public String welcome() {
        return "<h2 style color='red'>  Welcome to HRMS Application";
    }
}
