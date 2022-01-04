package com.languageschool.serviceusers.service.impl;

import com.languageschool.serviceusers.repo.UserRepo;
import com.languageschool.serviceusers.repo.model.LanguageLevel;
import com.languageschool.serviceusers.repo.model.User;
import com.languageschool.serviceusers.repo.model.UserType;
import com.languageschool.serviceusers.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public final class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    public List<User> fetchAllUsers() {
        return userRepo.findAll();
    }

    public User fetchUserById(long id) throws IllegalArgumentException {
        final Optional<User> maybeUser = userRepo.findById(id);

        if (maybeUser.isPresent())
            return maybeUser.get();
        else
            throw new IllegalArgumentException("Invalid user ID");
    }

    public long createUser(
            UserType userType,
            String firstName,
            String lastName,
            int age,
            LanguageLevel languageLevel,
            String userPic
    ) {
        final User user = new User(userType, firstName, lastName, age, languageLevel, userPic);
        final User savedUser = userRepo.save(user);

        return savedUser.getId();
    }

    public void updateUser(
            long id,
            UserType userType,
            String firstName,
            String lastName,
            int age,
            LanguageLevel languageLevel,
            String userPic
    ) throws IllegalArgumentException {
        final Optional<User> maybeUser = userRepo.findById(id);

        if (maybeUser.isEmpty())
            throw new IllegalArgumentException("Invalid user ID");

        final User user = maybeUser.get();
        if (userType != null) user.setUserType(userType);
        if (firstName != null && !firstName.isBlank()) user.setFirstName(firstName);
        if (lastName != null && !lastName.isBlank()) user.setLastName(lastName);
        if (age > 0) user.setAge(age);
        if (languageLevel != null) user.setLanguageLevel(languageLevel);
        if (userPic != null) user.setUserPic(userPic);
        userRepo.save(user);
    }

    public void deleteUser(long id) {
        userRepo.deleteById(id);
    }
}