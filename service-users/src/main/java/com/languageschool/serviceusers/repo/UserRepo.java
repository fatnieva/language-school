package com.languageschool.serviceusers.repo;

import com.languageschool.serviceusers.repo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
