package com.in28minutes.database.databasedemo.jdbc;

import com.in28minutes.database.databasedemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonJdbcDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    class PersonRowMapper implements RowMapper<Person>{

        @Override
        public Person mapRow(ResultSet resultSet, int i) throws SQLException {
            Person person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setLocation(resultSet.getString("location"));
            person.setBirthDate(resultSet.getTimestamp("birth_date"));
            return person;
        }
    }




    //SELECT * FROM person;
    public List<Person> findAll() {
        return jdbcTemplate.query("SELECT * FROM person",
                new PersonRowMapper());
    }

    //SELECT * FROM person WHERE id=?
    public Person getPersonById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM person WHERE id=?",
                new Object[]{id},
                new BeanPropertyRowMapper<Person>(Person.class));
    }

    //SELECT * FROM person WHERE name=?
    public Person getPersonByName(String name) {
        return jdbcTemplate.queryForObject("SELECT * FROM person WHERE name=?",
                new Object[]{name},
                new BeanPropertyRowMapper<Person>(Person.class));
    }

    //SELECT * FROM person WHERE location=?
    public Person getPersonByLocation(String location) {
        return jdbcTemplate.queryForObject("SELECT * FROM person WHERE location=?",
                new Object[]{location},
                new BeanPropertyRowMapper<Person>(Person.class));
    }

    //DELETE FROM person WHERE id=?
    public int deletePersonById(int id) {
        return jdbcTemplate.update("DELETE FROM person WHERE id=?",
                new Object[]{id});
    }

    //INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE) VALUES (?,?,?,?)
    public int insert(Person person) {
        return jdbcTemplate.update("INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE) VALUES (?,?,?,?)",
                new Object[]{
                        person.getId(),
                        person.getName(),
                        person.getLocation(),
                        new Timestamp(person.getBirthDate().getTime())
                });
    }

    //UPDATE person SET name=?, location =?, birth_date=? WHERE id=?
    public int update(Person person) {
        return jdbcTemplate.update("UPDATE person SET name=?, location =?, birth_date=? WHERE id=?",
                new Object[]{
                        person.getName(),
                        person.getLocation(),
                        new Timestamp(person.getBirthDate().getTime()),
                        person.getId()
                });
    }





}
