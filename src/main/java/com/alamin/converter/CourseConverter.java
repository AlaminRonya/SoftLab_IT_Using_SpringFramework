package com.alamin.converter;

import com.alamin.dto.CoursesDTO;
import com.alamin.dto.LanguageDTO;
import com.alamin.dto.UserDTO;
import com.alamin.models.Courses;
import com.alamin.models.Language;
import com.alamin.models.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseConverter {
    public CoursesDTO entityToDto(Courses course){
        return new ModelMapper().map(course, CoursesDTO.class);
    }
    public Courses DtoToEntity(CoursesDTO coursesDTO){
        return new ModelMapper().map(coursesDTO, Courses.class);
    }

    public List<CoursesDTO> entitiesToDto(List<Courses> courses) {
        return	courses.stream().map(this::entityToDto).collect(Collectors.toList());
    }
}
