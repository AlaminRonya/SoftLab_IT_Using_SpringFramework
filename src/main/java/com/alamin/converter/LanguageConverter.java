package com.alamin.converter;

import com.alamin.dto.CoursesDTO;
import com.alamin.dto.LanguageDTO;
import com.alamin.models.Courses;
import com.alamin.models.Language;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class LanguageConverter {
    public LanguageDTO entityToDto(Language language){
        return new ModelMapper().map(language, LanguageDTO.class);
    }
    public Language DtoToEntity(LanguageDTO languageDTO){
        return new ModelMapper().map(languageDTO, Language.class);
    }
}
