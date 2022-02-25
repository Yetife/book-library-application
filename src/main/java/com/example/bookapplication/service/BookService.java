package com.example.bookapplication.service;

import com.example.bookapplication.data.model.Book;
import com.example.bookapplication.dto.BookDtoRequest;
import com.example.bookapplication.web.exception.BookDoesNotExistException;
import com.example.bookapplication.web.exception.BusinessLogicException;

import java.util.List;

public interface BookService {
    Book createBookList(BookDtoRequest bookdto) throws BusinessLogicException;
    Book searchBookByAuthor(String author) throws BookDoesNotExistException;
    Book searchBookByTitle(String title) throws BookDoesNotExistException;
    List<Book> getAllBooks();
    Book findBooksById(Long id) throws BookDoesNotExistException;
//    Book searchBookByYear(int year) throws BookDoesNotExistException;
}
