package com.languageschool.serviceusers.api;


import com.languageschool.serviceusers.repo.model.LanguageLevel;
import com.languageschool.serviceusers.repo.model.User;
import com.languageschool.serviceusers.repo.model.UserType;
import com.languageschool.serviceusers.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public final class UserController {

    private final UserServiceImpl userServiceImpl;

    @GetMapping
    public ResponseEntity<List<User>> index() {
        final List<com.languageschool.serviceusers.repo.model.User> users = userServiceImpl.fetchAllUsers();

        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<com.languageschool.serviceusers.repo.model.User> showById(@PathVariable long id) {
        try {
            final com.languageschool.serviceusers.repo.model.User user = userServiceImpl.fetchUserById(id);

            return ResponseEntity.ok(user);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody com.languageschool.serviceusers.api.dto.User user) {
        final UserType userType = user.userType();
        final String firstName = user.firstName();
        final String lastName = user.lastName();
        final int age = user.age();
        final LanguageLevel languageLevel = user.languageLevel();
        final String userPic = user.userPic();
        final long userId = userServiceImpl.createUser(userType, firstName, lastName, age, languageLevel, userPic);
        final String userUri = String.format("/users/%d", userId);

        return ResponseEntity.created(URI.create(userUri)).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> change(@PathVariable long id, @RequestBody com.languageschool.serviceusers.api.dto.User user) {
        final UserType userType = user.userType();
        final String firstName = user.firstName();
        final String lastName = user.lastName();
        final int age = user.age();
        final LanguageLevel languageLevel = user.languageLevel();
        final String userPic = user.userPic();

        try {
            userServiceImpl.updateUser(id, userType, firstName, lastName, age, languageLevel, userPic);

            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        userServiceImpl.deleteUser(id);

        return ResponseEntity.noContent().build();
    }
}