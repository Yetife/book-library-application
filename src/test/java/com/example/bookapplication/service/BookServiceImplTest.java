package com.example.bookapplication.service;

import com.example.bookapplication.data.model.Book;
import com.example.bookapplication.data.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Sql(scripts = {"/db/insert.sql"})
class BookServiceImplTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    void createBookList() {
        Book book = new Book();
        book.setTitle("");
    }

    @Test
    void searchBookByAuthor() {
    }

    @Test
    void searchBookByTitle() {
    }

    @Test
    void getAllBooks() {

    }

    @Test
    void findBooksById() {
    }
}