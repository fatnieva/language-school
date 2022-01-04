package com.languageschool.servicecourses.service;

import com.languageschool.servicecourses.repo.model.*;

import java.math.BigDecimal;
import java.util.List;

public interface CourseService {
    List<Course> fetchAllCourses();
    Course fetchCourseById(long id) throws IllegalArgumentException;
    long createCourse(
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
    );

    void updateCourse(
            long id,
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
    ) throws IllegalArgumentException;

    void deleteCourse(long id);

}
