package com.example.bookapplication.data.repository;

import com.example.bookapplication.data.model.BookUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookUserRepository extends JpaRepository<BookUser, Long> {
}
