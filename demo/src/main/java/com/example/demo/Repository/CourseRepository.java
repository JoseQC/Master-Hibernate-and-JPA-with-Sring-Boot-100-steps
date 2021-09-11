package com.example.demo.Repository;

import com.example.demo.Entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    private EntityManager entityManager;

    public Course findById(long id){
        return entityManager.find(Course.class,id);
    }

    public void save(Course course){
        entityManager.persist(course);
    }

    public void update(Course course){
        entityManager.merge(course);
    }

    public void deleteById(long id){
        Course course = findById(id);
        entityManager.remove(course);
    }
}
