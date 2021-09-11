package com.example.demo;

import com.example.demo.Entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Logger;

@SpringBootTest
class NativeQueryTests {

    private final static Logger LOGGER = Logger.getLogger("com.example.demo.CourseRepositoryTests");

    @Autowired
    EntityManager entityManager;

    @Test
    void native_queries_basic(){
        Query query = entityManager.createNativeQuery("SELECT * from course");
        List resultList = query.getResultList();
        LOGGER.info("native quires {}"+resultList);

    }
    @Test
    void native_queries_with_parameter(){
        Query nativeQuery = entityManager.createNativeQuery("SELECT * FROM course where id=?", Course.class);
        nativeQuery.setParameter(1,1L);
        List<Course> resultList = nativeQuery.getResultList();
        LOGGER.info("test course with parameters {}"+resultList);

    }

    @Test
    void native_queries_with_name_parameter(){
        Query nativeQuery = entityManager.createNativeQuery("SELECT * FROM course where id=:id", Course.class);
        nativeQuery.setParameter("id",1L);
        List<Course> resultList = nativeQuery.getResultList();
        LOGGER.info("test course with named parameters {}"+resultList);

    }



    @Test
    void jpql_where(){
        TypedQuery<Course> typeQuery = entityManager.createNamedQuery("get_courses_like_a", Course.class);
        List<Course> resultList = typeQuery.getResultList();
        LOGGER.info("test where {}"+resultList);

    }




}
