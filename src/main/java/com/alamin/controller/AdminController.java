package com.alamin.controller;

import com.alamin.dto.CoursesDTO;
import com.alamin.dto.LanguageDTO;
import com.alamin.models.Language;
import com.alamin.services.LanguageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
    @Autowired
    private LanguageServices languageServices;
    @GetMapping("/language/insert")
    public String languagePage(Model model, @ModelAttribute("languageDTO") LanguageDTO languageDTO){
        return "insert_language";
    }
    @PostMapping("/language/insert")
    public String addLanguagePage(Model model, @ModelAttribute("languageDTO") LanguageDTO languageDTO){
        final Long aLong = languageServices.addLanguage(languageDTO);
        if (aLong == null){
            System.out.println("Not Inserted");
        }else {
            System.out.println("inserted");
        }

        return "insert_language";
    }
    @GetMapping("/courses/insert")
    public String coursePage(Model model, @ModelAttribute("coursesDTO")CoursesDTO coursesDTO){
        return "insert_courses";
    }
    @PostMapping("/courses/insert")
    public String addCoursePage(Model model, @ModelAttribute("coursesDTO")CoursesDTO coursesDTO){
        return "insert_courses";
    }
}
