package com.example.bookapplication.web.controller;

import com.example.bookapplication.data.model.Book;
import com.example.bookapplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
//@RequestMapping("/api/book")
public class BookController{

    @Autowired
    BookService bookService;

    @Autowired
    RestTemplate restTemplate;

//    @GetMapping()
//    public ResponseEntity<?> findAllBooks() {
//        List<Book> bookList = bookService.getAllBooks();
//        return ResponseEntity.ok().body(bookList);
//    }

    @GetMapping(value = "/books")
    public ResponseEntity<?> getBooks() {
        try{
            String uri = "https://gutendex.com/books/";
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(uri, String.class);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error!, please try again", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
