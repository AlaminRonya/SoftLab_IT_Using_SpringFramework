package com.alamin.services;

import com.alamin.converter.CourseConverter;
import com.alamin.dao.CoursesDAO;
import com.alamin.dto.CoursesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServices {
    @Autowired
    private CoursesDAO coursesDAO;
    private CourseConverter converter;



    public CourseServices() {
        converter = new CourseConverter();
    }

    public Long addCourse(CoursesDTO coursesDTO){
        return coursesDAO.insert(converter.DtoToEntity(coursesDTO));
    }

    public Long add(CoursesDTO courseDTO){
        return coursesDAO.insert(converter.DtoToEntity(courseDTO));
    }
}
