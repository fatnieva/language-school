package com.languageschool.servicelanguageclasses.api.dto;

import com.languageschool.servicelanguageclasses.repo.model.LanguageClassType;

import java.time.LocalDateTime;

public record LanguageClass(
        String name,
        LocalDateTime date,
        int duration,
        String location,
        LanguageClassType type
) { }
