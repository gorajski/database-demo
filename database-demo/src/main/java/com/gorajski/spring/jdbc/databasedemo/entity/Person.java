package com.gorajski.spring.jdbc.databasedemo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
//@Table(name = "person")  This is unneeded since the table name matches the class name.
public class Person {

    @Id //This IS needed since it indicates this property as a primary key
    @GeneratedValue //generates id based on database id generation mechanism
    private int id;
    //@Column(name = "name")  This is unneeded since the field name matches the property name.
    private String name;

    private String location;

    private Date birthDate;

    // Like JDBC, JPA as well requires a no-args constructor.
    public Person() {
    }

    // Using JPA's @GeneratedValue also requires a constructor that takes all args minus the id arg, since it is auto-generated
    public Person(String name, String location, Date birthDate) {
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    public Person(int id, String name, String location, Date birthDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "\nPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
