package com.alamin.services;

import com.alamin.converter.CourseConverter;
import com.alamin.converter.LanguageConverter;
import com.alamin.dao.CoursesDAO;
import com.alamin.dao.LanguageDAO;
import com.alamin.dao.UserDAO;
import com.alamin.dto.CoursesDTO;
import com.alamin.dto.LanguageDTO;
import com.alamin.models.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private LanguageDAO languageDAO;
    @Autowired
    private CoursesDAO coursesDAO;

    private final LanguageConverter languageConverter;
    private final CourseConverter courseConverter;

    public UserService() {
        languageConverter = new LanguageConverter();
        courseConverter = new CourseConverter();
    }

    public List<LanguageDTO> getAll(){
        return getLan();
    }

    public List<String> getAllCourses(){
        final List<CoursesDTO> courses = getCourses();
        if (!courses.isEmpty()){
            return courses.stream().map(e -> e.getCourseName()).collect(Collectors.toList());
        }
        return null;
    }

    private List<LanguageDTO> getLan() {
        return languageConverter.entityToDto(languageDAO.getAll());
    }
    private List<CoursesDTO> getCourses() {
        System.out.println(coursesDAO.getAll().size());
        return courseConverter.entitiesToDto(coursesDAO.getAll());
    }


}
