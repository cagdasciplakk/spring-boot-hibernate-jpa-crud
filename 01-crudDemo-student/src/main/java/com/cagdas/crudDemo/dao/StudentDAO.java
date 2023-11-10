package com.cagdas.crudDemo.dao;
import  java.util.List;


import com.cagdas.crudDemo.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByName(String theName);

    void update (Student theStudent);

    void delete (Integer id);

    int deleteAll();
}
