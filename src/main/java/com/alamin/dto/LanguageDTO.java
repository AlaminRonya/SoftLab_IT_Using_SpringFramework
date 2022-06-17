package com.alamin.dto;

import lombok.Data;

import java.util.List;

@Data
public class LanguageDTO {
    private Long id;
    private String name;
    private List<String> favLanguages;
}
