package com.espark.adarsh.service;

import com.espark.adarsh.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee getEmployee(Long empId);

    public Employee saveEmployee(Employee employee);

    public Employee updateEmployee(Long empId, Employee employee);

    public List<Employee> getAllEmployee();

    public Employee deleteEmployee(Long empId);
}
