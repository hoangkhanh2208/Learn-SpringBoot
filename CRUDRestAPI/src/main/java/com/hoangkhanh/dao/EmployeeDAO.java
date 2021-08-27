package com.hoangkhanh.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hoangkhanh.model.Employee;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {
    private static final Map<Long, Employee> empMap = new HashMap<>();

    static {
        initEmps();
    }

    private static void initEmps() {
        Employee emp1 = new Employee(1,"Khanh", 19);
        Employee emp2 = new Employee(2,"Linh", 22);
        Employee emp3 = new Employee(3,"Hoang", 42);

        empMap.put(emp1.getId(), emp1);
        empMap.put(emp2.getId(), emp2);
        empMap.put(emp3.getId(), emp3);
    }

    public Employee getEmployee(Long id) {
        return empMap.get(id);
    }

    public List<Employee> getAllEmployee() {
        Collection<Employee> colecEmp = empMap.values();
        List<Employee> listEmp = new ArrayList<>(colecEmp);
        return listEmp;
    }

    public Employee addEmployee(Employee emp) {
        empMap.put(emp.getId(), emp);
        return emp;
    }

    public void deleteEmployee(Long id) {
        empMap.remove(id);
    }

    public Employee updateEmployee(Employee employee) {
        empMap.put(employee.getId(), employee);
        return employee;
    }
}
