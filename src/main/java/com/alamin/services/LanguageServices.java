package com.alamin.services;

import com.alamin.converter.LanguageConverter;
import com.alamin.dao.LanguageDAO;
import com.alamin.dto.LanguageDTO;
import com.alamin.models.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServices {
    @Autowired
    private LanguageDAO languageDAO;
    private LanguageConverter languageConverter;

    public LanguageServices() {
        languageConverter = new LanguageConverter();
    }

    public Long addLanguage(LanguageDTO languageDTO){
        return languageDAO.insert(languageConverter.DtoToEntity(languageDTO));
    }
    public List<Language> getAll(){
        return languageDAO.getAll();
    }
}
