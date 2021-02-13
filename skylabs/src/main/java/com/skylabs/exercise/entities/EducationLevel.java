package com.skylabs.exercise.entities;

import javax.persistence.*;

@Entity
@Table(name = "education_levels")
public class EducationLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

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

    @Override
    public String toString() {
        return "EducationLevel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
