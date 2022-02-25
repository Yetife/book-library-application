package com.example.bookapplication.service;

import com.example.bookapplication.data.model.Book;
import com.example.bookapplication.data.model.BookUser;
import com.example.bookapplication.data.repository.BookRepository;
import com.example.bookapplication.dto.BookDtoRequest;
import com.example.bookapplication.web.exception.BookDoesNotExistException;
import com.example.bookapplication.web.exception.BusinessLogicException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    BookRepository bookRepository;
    @Override
    public Book createBookList(BookDtoRequest bookdto) throws BusinessLogicException {
        if (bookdto == null) throw new IllegalArgumentException("the book information cannot be null");

        Optional<Book> query = bookRepository.findBookByTitle(bookdto.getTitle());
        if (query.isPresent()){
            throw new BusinessLogicException("Book with title already exists");
        }
        Book book = new Book();
        book.setTitle(bookdto.getTitle());
        book.setAuthor(bookdto.getAuthor());
        book.setYearOfPublishing(bookdto.getYearOfPublishing());
        book.setImageUrl(bookdto.getImageUrl());
        book.setBookStatus(bookdto.getBookStatus());

        return bookRepository.save(book);
//
//        public void addBookToList(Book book) {
//            if (book == null)
//                favoriteBookList.add(book);
//
//        }
    }

    @Override
    public Book searchBookByAuthor(String author) throws BookDoesNotExistException {
        if(author == null) throw new IllegalArgumentException("author cant be null");
        Optional<Book>  book = bookRepository.findBookByAuthor(author);
        if(book.isEmpty())
        {
            throw new BookDoesNotExistException("the book with author "+ author + "does not exist");
        }
        Book queryBook = book.get();
     return    queryBook;
    }

    @Override
    public Book searchBookByTitle(String title) throws BookDoesNotExistException {
        if(title == null) throw new IllegalArgumentException("title can not be null");
       Optional<Book> book = bookRepository.findBookByTitle(title);
       if(book.isEmpty()) throw new BookDoesNotExistException(" the book with the title " + title + " does not exist");
       Book queryBook = book.get();
        return queryBook;
    }

    @Override
    public List<Book> getAllBooks() {
        return  bookRepository.findAll();
    }

    @Override
    public Book findBooksById(Long bookId) throws BookDoesNotExistException {
        if (bookId == null){
            throw new IllegalArgumentException("Id cannot be null");
        }
        Optional<Book> queryResult = bookRepository.findById(bookId);
        if (queryResult.isPresent()){
            return queryResult.get();
        }
        throw new BookDoesNotExistException("Product with ID :" + bookId + ": does not exists");
    }


}
