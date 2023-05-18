package com.noxirus.springbootcruddemo.rest;

import com.noxirus.springbootcruddemo.entity.Employee;
import com.noxirus.springbootcruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeedId}")
    public Employee findEmployeeById(@PathVariable int employeedId){
        Employee theEmployee = employeeService.findById(employeedId);

        if(theEmployee == null){
            throw new RuntimeException("Employee id not found " + employeedId);
        }

        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee tempEmployee = employeeService.findById(employeeId);
        if(tempEmployee == null){
            throw new RuntimeException("Employee id not found " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted: " + tempEmployee.getFirstName() + " " + tempEmployee.getLastName() + " " + employeeId;
    }
}
