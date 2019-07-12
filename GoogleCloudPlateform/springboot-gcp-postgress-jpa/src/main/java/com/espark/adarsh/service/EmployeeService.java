package com.espark.adarsh.service;

import com.espark.adarsh.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    Employee getEmployee(Long employeeId);

    List<Employee> getEmployees();

    Employee deleteEmployee(Long employeeId);
}
