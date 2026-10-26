package com.abes.hrms.model;

import com.abes.hrms.repository.EmpRepo;
import com.abes.hrms.repository.EmpRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class demoEmployee {

    @Autowired
    private EmpRepoImp empRepo;

    public int add(){
        return empRepo.add(20, 40);
    }


    public double squareRoot(){
        return empRepo.squareroot(200);
    }

    public int gtn(){
        return empRepo.gtn(20, 40);
    }

}
