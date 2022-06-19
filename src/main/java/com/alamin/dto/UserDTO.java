package com.alamin.dto;

import lombok.Data;


@Data
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Boolean gender;
    private String favLanguages;
    private String course;
    private String imagePath;
}
