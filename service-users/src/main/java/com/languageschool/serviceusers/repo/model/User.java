package com.languageschool.serviceusers.repo.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private UserType userType;
    private String firstName;
    private String lastName;
    private int age;
    private LanguageLevel languageLevel;
    private String userPic;

    public User() {

    }

    public User(UserType userType, String firstName, String lastName, int age, LanguageLevel languageLevel, String userPic) {
        this.userType = userType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.languageLevel = languageLevel;
        this.userPic = userPic;
    }

    public long getId() {
        return id;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LanguageLevel getLanguageLevel() {
        return languageLevel;
    }

    public void setLanguageLevel(LanguageLevel languageLevel) {
        this.languageLevel = languageLevel;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }
}
