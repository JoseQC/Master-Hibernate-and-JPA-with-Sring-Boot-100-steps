package com.example.demo;

import com.example.demo.Entity.Course;
import com.example.demo.Repository.CourseRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private CourseRepository courseRepository;

    private final static Logger LOGGER = Logger.getLogger("com.example.demo.DemoApplication");

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        courseRepository.save(new Course("Mathematics"));
        courseRepository.save(new Course("Physics"));
        courseRepository.save(new Course("Language"));
        LOGGER.info(courseRepository.findById(1L).toString());


    }
}
