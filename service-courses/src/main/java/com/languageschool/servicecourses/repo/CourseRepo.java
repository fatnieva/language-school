package com.languageschool.servicecourses.repo;

import com.languageschool.servicecourses.repo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Long> {
}
