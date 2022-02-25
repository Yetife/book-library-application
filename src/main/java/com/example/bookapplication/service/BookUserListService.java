package com.example.bookapplication.service;

import com.example.bookapplication.dto.BookUserRequestDto;
import com.example.bookapplication.dto.BookUserResponseDto;
import com.example.bookapplication.web.exception.BookDoesNotExistException;
import com.example.bookapplication.web.exception.UserNotFoundException;

public interface BookUserListService {

    BookUserResponseDto addBookTowishList(BookUserRequestDto wishListRequestDto) throws UserNotFoundException, BookDoesNotExistException;
    BookUserResponseDto viewWishList(Long userId) throws UserNotFoundException;

}
