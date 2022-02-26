package com.example.bookapplication.service;

import com.example.bookapplication.data.model.Book;
import com.example.bookapplication.data.model.BookUser;
import com.example.bookapplication.data.repository.BookRepository;
import com.example.bookapplication.data.repository.BookUserRepository;
import com.example.bookapplication.dto.BookUserRequestDto;
import com.example.bookapplication.dto.BookUserResponseDto;
import com.example.bookapplication.web.exception.BookDoesNotExistException;
import com.example.bookapplication.web.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookUserListServiceImpl implements BookUserListService {

    @Autowired
    BookUserRepository bookUserRepository;

    @Autowired
    BookRepository bookRepository;

    @Override
    public BookUserResponseDto addBookTowishList(BookUserRequestDto bookUserRequestDto) throws UserNotFoundException, BookDoesNotExistException {
        Optional<BookUser> query = bookUserRepository.findById(bookUserRequestDto.getUserId());
        if(query.isEmpty()){
            throw new UserNotFoundException("User with ID "+ bookUserRequestDto.getUserId()+" not found");
        }

        Book book = bookRepository.findById(13L).orElse(null);
        if(book == null){
            throw new BookDoesNotExistException("Product with ID "+ bookUserRequestDto.getBookId() +" does not exist");
        }
        return  null;
    }

    @Override
    public BookUserResponseDto viewWishList(Long userId) throws UserNotFoundException {

        return null;
    }
}
