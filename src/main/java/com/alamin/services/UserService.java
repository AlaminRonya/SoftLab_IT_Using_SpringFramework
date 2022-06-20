package com.alamin.services;

import com.alamin.converter.CourseConverter;
import com.alamin.converter.LanguageConverter;
import com.alamin.converter.UserConverter;
import com.alamin.dao.CoursesDAO;
import com.alamin.dao.LanguageDAO;
import com.alamin.dao.UserDAO;
import com.alamin.dto.CoursesDTO;
import com.alamin.dto.LanguageDTO;
import com.alamin.dto.UserDTO;
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
    private final UserConverter userConverter;

    public UserService() {
        languageConverter = new LanguageConverter();
        courseConverter = new CourseConverter();
        userConverter = new UserConverter();
    }

    public List<LanguageDTO> getAll(){
        return getLan();
    }

    public List<String> getAllCourses(){
        final List<CoursesDTO> courses = getCourses();
        if (!courses.isEmpty()){
            return courses.stream().map(CoursesDTO::getCourseName).collect(Collectors.toList());
        }
        return null;
    }

    private List<LanguageDTO> getLan() {
        return languageConverter.entityToDto(languageDAO.getAll());
    }

    private List<CoursesDTO> getCourses() {
        return courseConverter.entitiesToDto(coursesDAO.getAll());
    }


    public Long addUser(UserDTO userDTO) {
        return userDAO.insert(userConverter.DtoToEntity(userDTO));

    }
    public List<UserDTO> getAllUser(){
        return getUsers();
    }

    private List<UserDTO> getUsers() {
        return userConverter.entityToDto(userDAO.getAll());
    }

}
