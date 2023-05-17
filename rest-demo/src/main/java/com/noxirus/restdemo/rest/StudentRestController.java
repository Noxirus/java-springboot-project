package com.noxirus.restdemo.rest;

import com.noxirus.restdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> theStudents = new ArrayList<>();
        theStudents.add(new Student("Mickey", "Mouse"));
        theStudents.add(new Student("Minnie", "Mouse"));
        theStudents.add(new Student("Chip", "Dale"));

        return theStudents;
    }

}
