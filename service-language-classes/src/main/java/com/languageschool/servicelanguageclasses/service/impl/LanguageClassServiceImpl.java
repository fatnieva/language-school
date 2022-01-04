package com.languageschool.servicelanguageclasses.service.impl;

import com.languageschool.servicelanguageclasses.repo.LanguageClassRepo;
import com.languageschool.servicelanguageclasses.repo.model.LanguageClass;
import com.languageschool.servicelanguageclasses.repo.model.LanguageClassType;
import com.languageschool.servicelanguageclasses.service.LanguageClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public final class LanguageClassServiceImpl implements LanguageClassService {

    private final LanguageClassRepo languageClassRepo;

    public List<LanguageClass> fetchAllLanguageClasses() {
        return languageClassRepo.findAll();
    }

    public LanguageClass fetchLanguageClassById(long id) throws IllegalArgumentException {
        final Optional<LanguageClass> maybeLanguageClass = languageClassRepo.findById(id);

        if (maybeLanguageClass.isPresent())
            return maybeLanguageClass.get();
        else
            throw new IllegalArgumentException("Invalid languageClass ID");
    }

    public long createLanguageClass(
            String name,
            LocalDateTime date,
            int duration,
            String location,
            LanguageClassType type
    ) {
        final LanguageClass languageClass = new LanguageClass(name, date, duration, location, type);
        final LanguageClass savedLanguageClass = languageClassRepo.save(languageClass);

        return savedLanguageClass.getId();
    }

    public void updateLanguageClass(
            long id,
            String name,
            LocalDateTime date,
            int duration,
            String location,
            LanguageClassType type
    ) throws IllegalArgumentException {
        final Optional<LanguageClass> maybeLanguageClass = languageClassRepo.findById(id);

        if (maybeLanguageClass.isEmpty())
            throw new IllegalArgumentException("Invalid languageClass ID");

        final LanguageClass languageClass = maybeLanguageClass.get();
        if (name != null && !name.isBlank()) languageClass.setName(name);
        if (date != null) languageClass.setDate(date);
        if (duration > 0) languageClass.setDuration(duration);
        if (location != null && !location.isBlank()) languageClass.setLocation(location);
        if (type != null) languageClass.setType(type);
        languageClassRepo.save(languageClass);
    }

    public void deleteLanguageClass(long id) {
        languageClassRepo.deleteById(id);
    }
}
