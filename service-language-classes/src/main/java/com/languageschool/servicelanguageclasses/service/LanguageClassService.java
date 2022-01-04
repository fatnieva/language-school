package com.languageschool.servicelanguageclasses.service;

import com.languageschool.servicelanguageclasses.repo.model.LanguageClass;
import com.languageschool.servicelanguageclasses.repo.model.LanguageClassType;

import java.time.LocalDateTime;
import java.util.List;

public interface LanguageClassService {
    List<LanguageClass> fetchAllLanguageClasses();
    LanguageClass fetchLanguageClassById(long id) throws IllegalArgumentException;
    long createLanguageClass(
            String name,
            LocalDateTime date,
            int duration,
            String location,
            LanguageClassType type
    );

    void updateLanguageClass(
            long id,
            String name,
            LocalDateTime date,
            int duration,
            String location,
            LanguageClassType type
    ) throws IllegalArgumentException;

    void deleteLanguageClass(long id);

}
