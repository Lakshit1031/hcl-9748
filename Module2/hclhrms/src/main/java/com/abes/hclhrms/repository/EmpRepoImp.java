package com.abes.hclhrms.repository;

import com.abes.hclhrms.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmpRepoImp implements EmpRepo {

    private final List<Employee> emplist = new ArrayList<>();

    @Override
    public String addemp(Employee emp) {
        emplist.add(emp);
        return "Employee added successfully";
    }

    @Override
    public List<Employee> getEmp() {
        return new ArrayList<>(emplist);
    }

    @Override
    public Employee getEmpById(long emp_id) {
        for (Employee emp : emplist) {
            if (emp.getEmp_id() == emp_id) {
                return emp;
            }
        }
        return null;
    }

    @Override
    public Employee deleteById(long emp_id) {
        for (int i = 0; i < emplist.size(); i++) {
            if (emplist.get(i).getEmp_id() == emp_id) {
                return emplist.remove(i);
            }
        }
        return null;
    }

    @Override
    public String updateById(long emp_id, Employee updateEmp) {
        for (int i = 0; i < emplist.size(); i++) {
            if (emplist.get(i).getEmp_id() == emp_id) {
                emplist.set(i, updateEmp);
                return "Employee updated successfully";
            }
        }
        return "Employee not found";
    }

    @Override
    public String addEmpBulk(List<Employee> employees) {
        emplist.addAll(employees);
        return employees.size() + " employees added successfully";
    }
}