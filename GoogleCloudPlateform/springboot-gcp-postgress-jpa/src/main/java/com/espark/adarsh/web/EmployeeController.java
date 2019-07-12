package com.espark.adarsh.web;

import com.espark.adarsh.entity.Employee;
import com.espark.adarsh.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public Employee saveEmployee(Employee employee) {
        return this.employeeService.saveEmployee(employee);
    }

    @PutMapping("/employee")
    public Employee updateEmployee(Employee employee) {
        return this.employeeService.updateEmployee(employee);
    }

    @GetMapping("/employee/{employeeId}")
    public Employee getEmployee(@PathVariable("employeeId") Long employeeId) {
        return this.employeeService.getEmployee(employeeId);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return this.employeeService.getEmployees();
    }

    @DeleteMapping("/employee/{employeeId}")
    public Employee deleteEmployee(@PathVariable("employeeId") Long employeeId) {
        return this.employeeService.deleteEmployee(employeeId);
    }
}
