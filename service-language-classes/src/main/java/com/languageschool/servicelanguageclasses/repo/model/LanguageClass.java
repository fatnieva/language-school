package com.languageschool.servicelanguageclasses.repo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "language_classes")
public class LanguageClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private LocalDateTime date;
    private int duration;
    private String location;
    private LanguageClassType type;

    public LanguageClass(String name, LocalDateTime date, int duration, String location, LanguageClassType type) {
        this.name = name;
        this.date = date;
        this.duration = duration;
        this.location = location;
        this.type = type;
    }

    public LanguageClass() {

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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LanguageClassType getType() {
        return type;
    }

    public void setType(LanguageClassType type) {
        this.type = type;
    }
}
