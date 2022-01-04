package com.languageschool.servicelanguageclasses.repo;

import com.languageschool.servicelanguageclasses.repo.model.LanguageClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageClassRepo extends JpaRepository<LanguageClass, Long> {
}
