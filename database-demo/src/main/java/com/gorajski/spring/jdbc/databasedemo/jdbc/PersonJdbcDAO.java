package com.gorajski.spring.jdbc.databasedemo.jdbc;

import com.gorajski.spring.jdbc.databasedemo.entity.Person;
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
public class PersonJdbcDAO {

    @Autowired      //Typically, we'd want to create a Jdbc connection to the database, but since we're using Spring,
                    //we can let Spring wire up a connection by using the JdbcTemplate class.
    JdbcTemplate jdbcTemplate;

    class PersonRowMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setLocation(rs.getString("location"));
            person.setBirthDate(rs.getTimestamp("birth_date"));
            return person;
        }
    }

    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person", new PersonRowMapper());
        //Spring has a default mapper available to let us map incoming data into a POJO when the SQL properties
        //match the POJO fields.
    }

    public Person findById(int id) {
        return jdbcTemplate.queryForObject("select * from person where id=?", new Object[]{id},
                new PersonRowMapper());
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from person where id=?", new Object[] {id});
    }

    public int insert(Person person) {
        return jdbcTemplate.update(
                "INSERT INTO person(ID, NAME, LOCATION, BIRTH_DATE) VALUES(?,?,?,?)",
                new Object[] { person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()) });
    }

    public int update(Person person) {
        return jdbcTemplate.update(
                "UPDATE person set NAME = ?, LOCATION = ?, BIRTH_DATE = ? where id = ?",
                new Object[] { person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()), person.getId() });
    }

    public int updateByName(String name, Person person) {
        return jdbcTemplate.update(
                "UPDATE person set NAME = ?, LOCATION = ?, BIRTH_DATE = ? where NAME = ?",
                new Object[] { person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()), name });
    }

}
