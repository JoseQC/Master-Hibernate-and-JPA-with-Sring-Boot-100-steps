package com.in28minutes.database.databasedemo.jpa;

import com.in28minutes.database.databasedemo.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Person> findAll() {
        TypedQuery<Person> find_all_person = entityManager.createNamedQuery("find_all_person", Person.class);
        return  find_all_person.getResultList();
    }

    public Person findById(int id){
        return entityManager.find(Person.class,id);
    }

    public Person insert(Person person){
        return entityManager.merge(person);
    }

    public Person update(Person person){
        return entityManager.merge(person);
    }

    public void delete(int id){
        Person person = entityManager.find(Person.class,id);
        entityManager.remove(person);
    }

}
