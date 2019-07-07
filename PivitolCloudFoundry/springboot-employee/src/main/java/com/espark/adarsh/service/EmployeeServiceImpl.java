package com.espark.adarsh.service;

import com.espark.adarsh.entity.Employee;
import com.espark.adarsh.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployee(String empId) {
        return this.employeeRepository.getEmployee(empId);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return this.employeeRepository.saveEmployee(employee);
    }

    @Override
    public Employee updateEmployee(String empId, Employee employee) {
        return this.employeeRepository.updateEmployee(empId, employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return this.employeeRepository.getAllEmployee();
    }

    @Override
    public Employee deleteEmployee(String empId) {
        return this.employeeRepository.deleteEmployee(empId);
    }
}
