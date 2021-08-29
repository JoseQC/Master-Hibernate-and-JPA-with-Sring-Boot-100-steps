package com.in28minutes.database.databasedemo;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jdbc.PersonJdbcDao;
import com.in28minutes.database.databasedemo.jpa.PersonJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.logging.Logger;

@SpringBootApplication
public class SprigJdbcToJpaApplication implements CommandLineRunner {

    private final static Logger LOGGER = Logger.getLogger("com.in28minutes.database.databasedemo.SprigJdbcToJpaApplication");

    @Autowired
    PersonJdbcDao personJdbcDao;

    @Autowired
    PersonJpaRepository personJpaRepository;

    public static void main(String[] args) {
        SpringApplication.run(SprigJdbcToJpaApplication.class, args);
    }

    @Override
    public void run(String... args) {

        //Jbbc
        LOGGER.info("===============JDBC================");
        System.out.println("==================");
        System.out.println("Inserting Person"+personJdbcDao.insert(
                new Person(
                        4,
                        "Jose Luis",
                        "Huancayo",
                        new Date())));
        System.out.println(personJdbcDao.findAll());

         /*System.out.println("==================");
        System.out.println(dao.getPersonById(2));
        System.out.println("==================");
        System.out.println(dao.getPersonByName("Jose Luis"));
        System.out.println("==================");
        //System.out.println(dao.getPersonByLocation("Trujillo"));
        System.out.println("==================");
        //System.out.println(dao.deletePersonById(1));
        System.out.println("==================");
        //System.out.println("Inserting Person"+dao.insert(new Person(4,"Pepe","Lima",new Date())));
        System.out.println(dao.update(new Person(4,"Jose","Trujillo",new Date())));*/


        //jpa
        LOGGER.info("===============JPA================");
        LOGGER.info("Insert" + personJpaRepository.insert(
                new Person(
                        "Jose",
                        "Arequipa",
                        new Date())));
        LOGGER.info("Finding "+personJpaRepository.findById(4).toString());
        LOGGER.info("Updating "+personJpaRepository.update(new Person(
                1,
                "Luis",
                "Lima",
                new Date())
        ).toString());

        LOGGER.info("Deleting");
       // personJpaRepository.delete(4);

        LOGGER.info("Find all"+ personJpaRepository.findAll());










    }
}
