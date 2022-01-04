package com.languageschool.servicelanguageclasses.api;

import com.languageschool.servicelanguageclasses.repo.model.LanguageClass;
import com.languageschool.servicelanguageclasses.repo.model.LanguageClassType;
import com.languageschool.servicelanguageclasses.service.impl.LanguageClassServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/languageclass")
@RestController
public final class LanguageClassController {

    private final LanguageClassServiceImpl languageClassServiceImpl;

    @GetMapping
    public ResponseEntity<List<LanguageClass>> index() {
        final List<LanguageClass> languageClass = languageClassServiceImpl.fetchAllLanguageClasses();

        return ResponseEntity.ok(languageClass);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LanguageClass> showById(@PathVariable long id) {
        try {
            final LanguageClass languageClass = languageClassServiceImpl.fetchLanguageClassById(id);

            return ResponseEntity.ok(languageClass);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody com.languageschool.servicelanguageclasses.api.dto.LanguageClass languageClass) {
        final String name = languageClass.name();
        final LocalDateTime date = languageClass.date();
        final int duration = languageClass.duration();
        final String location = languageClass.location();
        final LanguageClassType type = languageClass.type();
        final long languageClassId = languageClassServiceImpl.createLanguageClass(name, date, duration, location, type);
        final String languageClassUri = String.format("/languageclass/%d", languageClassId);

        return ResponseEntity.created(URI.create(languageClassUri)).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> change(@PathVariable long id, @RequestBody com.languageschool.servicelanguageclasses.api.dto.LanguageClass languageClass) {
        final String name = languageClass.name();
        final LocalDateTime date = languageClass.date();
        final int duration = languageClass.duration();
        final String location = languageClass.location();
        final LanguageClassType type = languageClass.type();

        try {
            languageClassServiceImpl.updateLanguageClass(id, name, date, duration, location, type);

            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        languageClassServiceImpl.deleteLanguageClass(id);

        return ResponseEntity.noContent().build();
    }
}