package com.espark.adarsh.controller;

import com.espark.adarsh.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.espark.adarsh.entity.Employee;

import java.util.List;

@RestController
public class ApplicationController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable("id") Long id) {
        return this.employeeService.getEmployee(id);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public List<Employee> getEmployees() {
        return this.employeeService.getAllEmployee();
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
    public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
        return this.employeeService.updateEmployee(id, employee);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public Employee deleteEmployee(@PathVariable("id") Long id) {
        return this.employeeService.deleteEmployee(id);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public Employee createEmployee(@RequestBody Employee employee) {
        return this.employeeService.saveEmployee(employee);
    }


}