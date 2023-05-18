package com.noxirus.springbootcruddemo.dao;

import com.noxirus.springbootcruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //This is handling the DAO
    //It is also handling the REST Controller
    //Sorting: http://localhost:8080/magic-api/employees?sort=lastName,desc
}
