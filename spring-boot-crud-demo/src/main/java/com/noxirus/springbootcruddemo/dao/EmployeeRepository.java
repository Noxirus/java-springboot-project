package com.noxirus.springbootcruddemo.dao;

import com.noxirus.springbootcruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
