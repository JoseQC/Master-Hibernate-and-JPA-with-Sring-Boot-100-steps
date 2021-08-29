package com.example.demo.Repository;

import com.example.demo.Entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class CourseRepository {

    @Autowired
    private EntityManager entityManager;

    public Course findById(int id){
        return entityManager.find(Course.class,id);
    }

    public void save(Course course){
        entityManager.merge(course);
    }
}
