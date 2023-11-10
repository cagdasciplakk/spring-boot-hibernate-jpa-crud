package com.cagdas.crudDemo.dao;

import com.cagdas.crudDemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
    entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery=entityManager.createQuery("From Student",Student.class);


        return theQuery.getResultList();

    }

    @Override
    public List<Student> findByName(String theName) {

        TypedQuery<Student> theQuery=entityManager.createQuery("From Student where firstName=:theData",Student.class);
        theQuery.setParameter("theData",theName);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student theStudent = entityManager.find(Student.class,id);
        entityManager.remove(theStudent);

    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted=entityManager.createQuery("Delete From Student").executeUpdate();
        return numRowsDeleted;
    }


}
