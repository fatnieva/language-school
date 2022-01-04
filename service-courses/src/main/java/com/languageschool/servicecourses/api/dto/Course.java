package com.languageschool.servicecourses.api.dto;

import com.languageschool.servicecourses.repo.model.*;

import java.math.BigDecimal;

public record Course(
        String name,
        String description,
        CourseDuration duration,
        CourseLanguage language,
        BigDecimal cost,
        long teacherId,
        int courseSize,
        LanguageLevel languageLevel,
        StudyType studyType,
        CourseStatus status
) { }
