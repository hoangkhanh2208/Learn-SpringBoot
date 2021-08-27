package com.hoangkhanh.controller;

import java.util.List;

import com.hoangkhanh.dao.EmployeeDAO;
import com.hoangkhanh.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    
    @Autowired
    private EmployeeDAO employeeDAO;

    @GetMapping("/getAll")
    public List<Employee> getAll() {
        return employeeDAO.getAllEmployee();
    }
    
    @GetMapping("/getEmpl/{id}")
    public Employee getEmployee(@PathVariable("id") long id) {
        return employeeDAO.getEmployee(id);
    }

    @PostMapping("/addEmpl")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeDAO.addEmployee(employee);
    }

    @DeleteMapping("/deleteEmpl/{id}")
    public void deleteEmployee(@PathVariable("id") long id) {
        employeeDAO.deleteEmployee(id);
    }
}
