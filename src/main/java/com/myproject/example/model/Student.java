package com.myproject.example.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ubuntu on 30/12/18.
 */
//@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Embedded
    private Address address;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "student_course"
//            , joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id")
//            , inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
//    private List<Course> courses = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

//    public List<Course> getCourses() {
//        return courses;
//    }
//
//    public void setCourses(List<Course> courses) {
//        this.courses = courses;
//    }
}
