package com.example.bookapplication.service;

import com.example.bookapplication.dto.WishListRequestDto;
import com.example.bookapplication.dto.WishListResponseDto;
import com.example.bookapplication.web.exception.BookDoesNotExistException;
import com.example.bookapplication.web.exception.UserNotFoundException;

public interface UserwishListService {

    WishListResponseDto addBookTowishList(WishListRequestDto wishListRequestDto) throws UserNotFoundException, BookDoesNotExistException;
    WishListResponseDto viewWishList(Long userId) throws UserNotFoundException;

}
