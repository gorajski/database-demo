package com.gorajski.spring.jdbc.databasedemo.springdata;

import com.gorajski.spring.jdbc.databasedemo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface PersonSpringDataRepository extends JpaRepository<Person, Integer> {

}
