package com.alamin.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "locations")
@Data
public class User implements Serializable{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String password;
    private Boolean gender;
    private List<String> favLanguages;
    private String course;
    private String imagePath;
}
