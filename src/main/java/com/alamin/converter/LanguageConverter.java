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
public class LanguageConverter {
    public LanguageDTO entityToDto(Language language){
        return new ModelMapper().map(language, LanguageDTO.class);
    }
    public Language DtoToEntity(LanguageDTO languageDTO){
        return new ModelMapper().map(languageDTO, Language.class);
    }

    public List<LanguageDTO> entityToDto(List<Language> languages) {
        return	languages.stream().map(this::entityToDto).collect(Collectors.toList());
    }
}
