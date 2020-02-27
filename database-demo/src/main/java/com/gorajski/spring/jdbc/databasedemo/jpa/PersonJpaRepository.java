package com.gorajski.spring.jdbc.databasedemo.jpa;

import com.gorajski.spring.jdbc.databasedemo.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional  //Manages each transaction creation, retries, rollbacks and destruction
public class PersonJpaRepository {

    //connect to the database
    @PersistenceContext             //Entities are stored in the PersistenceContext
    EntityManager entityManager;    // Defines interface which describes how Entities are managed by JPA

    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }
}
