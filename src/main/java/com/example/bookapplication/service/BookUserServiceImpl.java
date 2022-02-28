package com.example.bookapplication.service;

import com.example.bookapplication.data.model.Book;
import com.example.bookapplication.data.model.BookUser;
import com.example.bookapplication.data.repository.BookRepository;
import com.example.bookapplication.data.repository.BookUserRepository;
import com.example.bookapplication.dto.BookResponseDto;
import com.example.bookapplication.dto.BookUserRequestDto;
import com.example.bookapplication.dto.BookUserResponseDto;
import com.example.bookapplication.web.exception.BookDoesNotExistException;
import com.example.bookapplication.web.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookUserServiceImpl implements BookUserService{

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookUserRepository bookUserRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public BookUserResponseDto registerUser(BookUserRequestDto userRequestDto) throws UserNotFoundException {
        Optional<BookUser> savedUser = bookUserRepository.findByEmail(userRequestDto.getEmail());
        if (savedUser.isPresent()) {
            throw new UserNotFoundException("User with email"+ userRequestDto.getEmail()+ "already exist");
        }
        BookUser newUser = new BookUser();
        newUser.setEmail(userRequestDto.getEmail());
        newUser.setPassword(bCryptPasswordEncoder.encode(userRequestDto.getPassword()));
        newUser.setFirstName(userRequestDto.getFirstName());
        newUser.setLastName(userRequestDto.getLastName());
        newUser.setAddress(userRequestDto.getAddress());

        bookUserRepository.save(newUser);
        return buildResponse(newUser);
    }

    private BookUserResponseDto buildResponse(BookUser bookUser) {
        return BookUserResponseDto.builder().firstName(bookUser.getFirstName())
                .lastName(bookUser.getLastName())
                .email(bookUser.getEmail()).address(bookUser.getAddress()).build();
    }
}
