package com.alamin.services;

import com.alamin.converter.LanguageConverter;
import com.alamin.dao.LanguageDAO;
import com.alamin.dto.LanguageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
