package com.espark.adarsh.repository;


import com.espark.adarsh.entity.Employee;

import java.util.List;

public interface EmployeeRepository {

    public Employee getEmployee(String empId);

    public Employee deleteEmployee(String empId);

    public Employee saveEmployee(Employee employee);

    public Employee updateEmployee(String empId, Employee employee);

    public List<Employee> getAllEmployee();


}
