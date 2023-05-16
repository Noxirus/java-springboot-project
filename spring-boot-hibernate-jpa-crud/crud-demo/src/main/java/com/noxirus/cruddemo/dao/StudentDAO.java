package com.noxirus.cruddemo.dao;

import com.noxirus.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Integer id);

}
