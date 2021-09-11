package com.example.demo;

import com.example.demo.Entity.Course;
import com.example.demo.Repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class JPQLTests {

    private final static Logger LOGGER = Logger.getLogger("com.example.demo.CourseRepositoryTests");

    @Autowired
    EntityManager entityManager;

    @Test
    void jpql_basic(){
        Query query = entityManager.createNamedQuery("get_all_courses");
        List resultList = query.getResultList();
        LOGGER.info("test {}"+resultList);

    }
    @Test
    void jpql_typed(){
        TypedQuery<Course> typeQuery = entityManager.createNamedQuery("get_all_courses", Course.class);
        List<Course> resultList = typeQuery.getResultList();
        LOGGER.info("test type {}"+resultList);

    }

    @Test
    void jpql_where(){
        TypedQuery<Course> typeQuery = entityManager.createNamedQuery("get_courses_like_a", Course.class);
        List<Course> resultList = typeQuery.getResultList();
        LOGGER.info("test where {}"+resultList);

    }




}
