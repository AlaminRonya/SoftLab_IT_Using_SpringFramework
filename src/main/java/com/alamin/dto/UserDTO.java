package com.alamin.dto;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String gender;
    private String favLanguages;
    private String course;
    private String imagePath;
}
