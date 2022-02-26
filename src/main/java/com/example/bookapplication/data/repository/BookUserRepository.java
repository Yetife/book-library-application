package com.example.bookapplication.data.repository;

import com.example.bookapplication.data.model.BookUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookUserRepository extends JpaRepository<BookUser, Long> {

    Optional<BookUser> findByEmail(String email);
}
