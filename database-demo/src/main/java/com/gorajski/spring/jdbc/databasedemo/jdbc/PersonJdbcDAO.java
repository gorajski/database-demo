package com.gorajski.spring.jdbc.databasedemo.jdbc;

import com.gorajski.spring.jdbc.databasedemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonJdbcDAO {

    @Autowired      //Typically, we'd want to create a Jdbc connection to the database, but since we're using Spring,
                    //we can let Spring wire up a connection by using the JdbcTemplate class.
    JdbcTemplate jdbcTemplate;


    public List<Person> findAll() {
        jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<>(Person.class));
        //Spring has a default mapper available to let us map incoming data into a POJO when the SQL properties
        //match the POJO fields.

    }

}
