package com.espark.adarsh.service;

import com.espark.adarsh.entity.Employee;
import com.espark.adarsh.exception.ApplicationException;
import com.espark.adarsh.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class EmployeeServiceImpl  implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        if (this.employeeRepository.existsById(employee.getId())) {
            return this.employeeRepository.save(employee);
        }
        throw new ApplicationException("employee not found for update " + employee.getId());
    }

    @Override
    public Employee getEmployee(Long employeeId) {
        if (this.employeeRepository.existsById(employeeId)) {
            return this.employeeRepository.findById(employeeId).get();
        }
        throw new ApplicationException("employee not found " + employeeId);
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employeeList = new LinkedList<>();
        this.employeeRepository.findAll().forEach(employee -> employeeList.add(employee));
        return employeeList;
    }

    @Override
    public Employee deleteEmployee(Long employeeId) {
        if (this.employeeRepository.existsById(employeeId)) {
            Employee employee = this.getEmployee(employeeId);
            this.employeeRepository.delete(employee);
            return employee;
        }
        throw new ApplicationException("employee not found for delete " + employeeId);
    }
}
