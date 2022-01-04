package com.languageschool.serviceusers.api.dto;

import com.languageschool.serviceusers.repo.model.LanguageLevel;
import com.languageschool.serviceusers.repo.model.UserType;

public record User(
        UserType userType,
        String firstName,
        String lastName,
        int age,
        LanguageLevel languageLevel,
        String userPic
) { }
