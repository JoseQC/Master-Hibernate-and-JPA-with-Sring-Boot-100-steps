package com.example.demo;

import com.example.demo.Entity.Course;
import com.example.demo.Repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class CourseRepositoryTests {

    private final static Logger LOGGER = Logger.getLogger("com.example.demo.CourseRepositoryTests");

    @Autowired
    CourseRepository courseRepository;

    @Test
    void findById(){
        Course findCouseById = courseRepository.findById(1L);
        assertEquals("Mathematics", findCouseById.getName());
    }

    @Test
    void deleteCouse(){

        courseRepository.deleteById(1L);
        assertNull(courseRepository.findById(1L));
    }

    @Test
    void saveCourse(){

        courseRepository.save(new Course("Algorithms"));

        //get
        courseRepository.deleteById(1L);
        assertNull(courseRepository.findById(1L));
    }


}
