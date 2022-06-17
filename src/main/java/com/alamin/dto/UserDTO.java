package com.alamin.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Boolean gender;
    private List<String> favLanguages;
    private String course;
    private String imagePath;
}
