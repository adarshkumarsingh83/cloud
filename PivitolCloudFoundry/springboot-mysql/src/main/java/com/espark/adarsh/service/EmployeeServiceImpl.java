package com.espark.adarsh.service;

import com.espark.adarsh.entity.Employee;
import com.espark.adarsh.exception.ApplicationException;
import com.espark.adarsh.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @PostConstruct
    public void init() {
        for (long i = 1; i <= 10; i++) {
            Employee emp = new Employee();
            emp.setEmpName("emp" + i);
            emp.setEmpId(i);
            saveEmployee(emp);
        }
    }

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployee(Long empId) {
        if (employeeRepository.existsById(empId)) {
            Employee employee = getEmployee(empId);
            return employee;
        }
        throw new ApplicationException("emp not found");
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        if (!employeeRepository.existsById(employee.getEmpId())) {
            return employeeRepository.save(employee);
        }
        throw new ApplicationException("emp found found");
    }

    @Override
    public Employee updateEmployee(Long empId, Employee employee) {
        if (employeeRepository.existsById(empId)) {
            return employeeRepository.save(employee);
        }
        throw new ApplicationException("emp not found");
    }

    @Override
    public List<Employee> getAllEmployee() {
        if (employeeRepository.count() > 0) {
            List<Employee> list = new LinkedList<>();
            Iterable<Employee> employee = employeeRepository.findAll();
            employee.forEach(employee1 -> list.add(employee1));
            return list;
        }
        throw new ApplicationException("emp not found");
    }

    @Override
    public Employee deleteEmployee(Long empId) {
        if (employeeRepository.existsById(empId)) {
            Employee employee = getEmployee(empId);
            employeeRepository.delete(employee);
            return employee;
        }
        throw new ApplicationException("emp not found");
    }
}
