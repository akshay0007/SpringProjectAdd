package com.myproject.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stpl on 1/1/19.
 */
@Entity
public class Course implements Serializable {

    @Column(name = "course_name")
    private String name;

    @Id
    @GeneratedValue
    private long id;

    @OneToMany(mappedBy = "course")
    private List<Review> review = new ArrayList();

    @ManyToMany
    @JsonIgnore
    private List<Student> students = new ArrayList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
