package com.example.bookapplication.web.controller;

import com.example.bookapplication.data.model.Book;
import com.example.bookapplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController{

    @Autowired
    BookService bookService;

    @GetMapping()
    public ResponseEntity<?> findAllBooks() {
        List<Book> books = bookService.getAllBooks();
    }
}
