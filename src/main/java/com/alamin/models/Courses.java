package com.alamin.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "courses_tbl")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String courseName;
}
