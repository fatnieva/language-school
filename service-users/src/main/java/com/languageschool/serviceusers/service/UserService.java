package com.languageschool.serviceusers.service;

import com.languageschool.serviceusers.repo.model.LanguageLevel;
import com.languageschool.serviceusers.repo.model.User;
import com.languageschool.serviceusers.repo.model.UserType;

import java.util.List;

public interface UserService {
    List<User> fetchAllUsers();
    User fetchUserById(long id) throws IllegalArgumentException;
    long createUser(
            UserType userType,
            String firstName,
            String lastName,
            int age,
            LanguageLevel languageLevel,
            String userPic
    );

    void updateUser(
            long id,
            UserType userType,
            String firstName,
            String lastName,
            int age,
            LanguageLevel languageLevel,
            String userPic
    ) throws IllegalArgumentException;

    void deleteUser(long id);

}
