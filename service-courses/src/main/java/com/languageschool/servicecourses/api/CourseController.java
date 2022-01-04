package com.languageschool.servicecourses.api;

import com.languageschool.servicecourses.repo.model.*;
import com.languageschool.servicecourses.service.impl.CourseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/courses")
@RestController
public final class CourseController {

    private final CourseServiceImpl courseServiceImpl;

    @GetMapping
    public ResponseEntity<List<Course>> index() {
        final List<Course> courses = courseServiceImpl.fetchAllCourses();

        return ResponseEntity.ok(courses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> showById(@PathVariable long id) {
        try {
            final Course course = courseServiceImpl.fetchCourseById(id);

            return ResponseEntity.ok(course);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody com.languageschool.servicecourses.api.dto.Course course) {
        final String name = course.name();
        final String description = course.description();
        final CourseDuration duration = course.duration();
        final CourseLanguage language = course.language();
        final BigDecimal cost = course.cost();
        final long teacherId = course.teacherId();
        final int courseSize = course.courseSize();
        final LanguageLevel languageLevel = course.languageLevel();
        final StudyType studyType = course.studyType();
        final CourseStatus status = course.status();
        final long courseId = courseServiceImpl.createCourse(name, description, duration, language, cost, teacherId, courseSize, languageLevel, studyType, status);
        final String courseUri = String.format("/courses/%d", courseId);

        return ResponseEntity.created(URI.create(courseUri)).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> change(@PathVariable long id, @RequestBody com.languageschool.servicecourses.api.dto.Course course) {
        final String name = course.name();
        final String description = course.description();
        final CourseDuration duration = course.duration();
        final CourseLanguage language = course.language();
        final BigDecimal cost = course.cost();
        final long teacherId = course.teacherId();
        final int courseSize = course.courseSize();
        final LanguageLevel languageLevel = course.languageLevel();
        final StudyType studyType = course.studyType();
        final CourseStatus status = course.status();

        try {
            courseServiceImpl.updateCourse(id, name, description, duration, language, cost, teacherId, courseSize, languageLevel, studyType, status);

            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        courseServiceImpl.deleteCourse(id);

        return ResponseEntity.noContent().build();
    }
}