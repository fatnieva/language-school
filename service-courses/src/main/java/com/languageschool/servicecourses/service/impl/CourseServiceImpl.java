package com.languageschool.servicecourses.service.impl;

import com.languageschool.servicecourses.repo.CourseRepo;
import com.languageschool.servicecourses.repo.model.*;
import com.languageschool.servicecourses.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public final class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;

    public List<Course> fetchAllCourses() {
        return courseRepo.findAll();
    }

    public Course fetchCourseById(long id) throws IllegalArgumentException {
        final Optional<Course> maybeCourse = courseRepo.findById(id);

        if (maybeCourse.isPresent())
            return maybeCourse.get();
        else
            throw new IllegalArgumentException("Invalid course ID");
    }

    public long createCourse(
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
    ) {
        final Course course = new Course(name, description, duration, language, cost, teacherId, courseSize, languageLevel, studyType, status);
        final Course savedCourse = courseRepo.save(course);

        return savedCourse.getId();
    }

    public void updateCourse(
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
    ) throws IllegalArgumentException {
        final Optional<Course> maybeCourse = courseRepo.findById(id);

        if (maybeCourse.isEmpty())
            throw new IllegalArgumentException("Invalid course ID");

        final Course course = maybeCourse.get();
        if (name != null && !name.isBlank()) course.setName(name);
        if (description != null && !description.isBlank()) course.setDescription(description);
        if (duration != null) course.setDuration(duration);
        if (language != null) course.setLanguage(language);
        if (cost != null) course.setCost(cost);
        if (teacherId > 0) course.setTeacherId(teacherId);
        if (courseSize > 0) course.setCourseSize(courseSize);
        if (languageLevel != null) course.setLanguageLevel(languageLevel);
        if (studyType != null) course.setStudyType(studyType);
        if (status != null) course.setStatus(status);
        courseRepo.save(course);
    }

    public void deleteCourse(long id) {
        courseRepo.deleteById(id);
    }
}
