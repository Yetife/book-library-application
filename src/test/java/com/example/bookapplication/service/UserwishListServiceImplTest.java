package com.example.bookapplication.service;

import com.example.bookapplication.data.repository.BookUserRepository;
import com.example.bookapplication.dto.BookUserRequestDto;
import com.example.bookapplication.dto.BookUserResponseDto;
import com.example.bookapplication.web.exception.BookDoesNotExistException;
import com.example.bookapplication.web.exception.UserNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Sql(scripts = {"/db/insert.sql"})
class UserwishListServiceImplTest {

    @Autowired
    BookUserListService userwishListService;

    @Autowired
    BookUserRepository bookUserRepository;

    @Test
    void addBookTowishList() throws UserNotFoundException, BookDoesNotExistException {
        BookUserRequestDto wishListRequestDto = new BookUserRequestDto();
        wishListRequestDto.setBookId(12L);
        wishListRequestDto.setUserId(510L);
        wishListRequestDto.setTitle("Think big");

        BookUserResponseDto wishListResponseDto = userwishListService.addBookTowishList(wishListRequestDto);
        assertThat(wishListResponseDto.getBookList()).isNotNull();
        assertThat(wishListResponseDto.getBookList().size()).isEqualTo(1);
    }
}