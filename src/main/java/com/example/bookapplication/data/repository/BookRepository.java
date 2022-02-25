package com.example.bookapplication.data.repository;

import com.example.bookapplication.data.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book>  findBookByTitle( String title);
//    Optional<Book>  findBookByYear(int Year);
   Optional<Book>   findBookByAuthor(String author);
}
