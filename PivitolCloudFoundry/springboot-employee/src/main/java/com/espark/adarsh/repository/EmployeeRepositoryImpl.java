package com.espark.adarsh.repository;

import com.espark.adarsh.entity.Employee;
import com.espark.adarsh.exception.ApplicationException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {


    public Map<String, Employee> dataStore = new HashMap<>();


    @PostConstruct
    public void init() {
        for (int i = 0; i < 10; i++) {
            Employee emp = new Employee();
            emp.setName("emp" + i);
            emp.setDesignation("manager");
            emp.setEmpId(i + "");
            emp.setSalary(3000);
            dataStore.put(emp.getEmpId(), emp);
        }
    }


    @Override
    public Employee getEmployee(String empId) {
        if (dataStore.containsKey(empId)) {
            return dataStore.get(empId);
        }
        throw new ApplicationException("emp not found");
    }

    @Override
    public Employee deleteEmployee(String empId) {
        if (dataStore.containsKey(empId)) {
            return dataStore.remove(empId);
        }
        throw new ApplicationException("emp not found");
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        if (!dataStore.containsKey(employee.getEmpId())) {
            return dataStore.put(employee.getEmpId(), employee);
        }
        throw new ApplicationException("emp already found");
    }

    @Override
    public Employee updateEmployee(String empId, Employee employee) {
        if (dataStore.containsKey(employee.getEmpId())) {
            return dataStore.put(employee.getEmpId(), employee);
        }
        throw new ApplicationException("emp not found");
    }

    @Override
    public List<Employee> getAllEmployee() {
        if (!dataStore.isEmpty()) {
            return dataStore.entrySet().stream().map(entry -> entry.getValue()).collect(Collectors.toList());
        }
        throw new ApplicationException("emp not found");
    }
}
