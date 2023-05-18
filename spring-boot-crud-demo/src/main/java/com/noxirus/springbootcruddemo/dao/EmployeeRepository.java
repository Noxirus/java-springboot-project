package com.noxirus.springbootcruddemo.dao;

import com.noxirus.springbootcruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //This is handling the DAO
    //It is also handling the REST Controller

}
