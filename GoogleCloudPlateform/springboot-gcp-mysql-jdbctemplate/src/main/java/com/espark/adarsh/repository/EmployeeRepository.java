package com.espark.adarsh.repository;

import com.espark.adarsh.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Slf4j
@Repository
public class EmployeeRepository {

    @Autowired
    private JdbcTemplate template;

    private RowMapper<Employee> rowMapper
            = (rs, rowNum) -> new Employee(rs.getLong("id"),
            rs.getString("name"));


    public Collection<Employee> getAllEmployee() {
        Collection<Employee> employees = this.template
                .query("select * from espark", this.rowMapper);
        employees.forEach(employee -> log.info("employee: " + employee.toString()));
        return employees;
    }
}
