package com.languageschool.servicecourses.repo.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private CourseDuration duration;
    private CourseLanguage language;
    private BigDecimal cost;
    private long teacherId;
    private int courseSize;
    private LanguageLevel languageLevel;
    private StudyType studyType;
    private CourseStatus status;

    public Course() {

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CourseDuration getDuration() {
        return duration;
    }

    public void setDuration(CourseDuration duration) {
        this.duration = duration;
    }

    public CourseLanguage getLanguage() {
        return language;
    }

    public void setLanguage(CourseLanguage language) {
        this.language = language;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public int getCourseSize() {
        return courseSize;
    }

    public void setCourseSize(int courseSize) {
        this.courseSize = courseSize;
    }

    public LanguageLevel getLanguageLevel() {
        return languageLevel;
    }

    public void setLanguageLevel(LanguageLevel languageLevel) {
        this.languageLevel = languageLevel;
    }

    public StudyType getStudyType() {
        return studyType;
    }

    public void setStudyType(StudyType studyType) {
        this.studyType = studyType;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public void setStatus(CourseStatus status) {
        this.status = status;
    }

    public Course(String name, String description, CourseDuration duration, CourseLanguage language, BigDecimal cost, long teacherId, int courseSize, LanguageLevel languageLevel, StudyType studyType, CourseStatus status) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.language = language;
        this.cost = cost;
        this.teacherId = teacherId;
        this.courseSize = courseSize;
        this.languageLevel = languageLevel;
        this.studyType = studyType;
        this.status = status;
    }
}