package com.noxirus.restdemo.rest;

import com.noxirus.restdemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> theStudents;

    @PostConstruct
    public void populateData(){
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Mickey", "Mouse"));
        theStudents.add(new Student("Minnie", "Mouse"));
        theStudents.add(new Student("Chip", "Dale"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        if((studentId >= theStudents.size()) || (studentId < 0)){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return theStudents.get(studentId);
    }
}
