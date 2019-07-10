package com.espark.adarsh.repository;

import com.espark.adarsh.entity.Employee;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, String> {

}
