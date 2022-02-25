package com.example.bookapplication.data.repository;

import com.example.bookapplication.data.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Sql(scripts = {"/db/insert.sql"})
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    @DisplayName("Add book to the database test")
    void addBookToTheDatabaseTest() {
        Book book = new Book();
        book.setTitle("Python Programming");
        book.setAuthor("Deitel Deitel");
        book.setYearOfPublishing(2010);
        book.setDescription("A programming book for python language");

        assertThat(book.getId()).isNull();
        bookRepository.save(book);
        assertThat(book.getId()).isNotNull();
        assertThat(book.getTitle()).isEqualTo("Python Programming");
        assertThat(book.getAuthor()).isEqualTo("Deitel Deitel");
        assertThat(book.getYearOfPublishing()).isEqualTo(2010);
    }

    @Test
    void findBookByTitle() {
        Book book = bookRepository.findBookByTitle("Think big").orElse(null);
        assertThat(book).isNotNull();
        assertThat(book.getId()).isEqualTo(12L);
        assertThat(book.getAuthor()).isEqualTo("Ben Carson");
        assertThat(book.getYearOfPublishing()).isEqualTo(2015);
    }

    @Test
    void findBookByYear() {
    }

    @Test
    void findBookByAuthor() {
        Book book = bookRepository.findBookByAuthor("Ben Carson").orElse(null);
        assertThat(book).isNotNull();
        assertThat(book.getId()).isEqualTo(12L);
        assertThat(book.getTitle()).isEqualTo("Think big");
        assertThat(book.getYearOfPublishing()).isEqualTo(2015);
    }
}