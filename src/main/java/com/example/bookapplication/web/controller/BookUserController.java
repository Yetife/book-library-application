package com.example.bookapplication.web.controller;

import com.example.bookapplication.dto.BookUserRequestDto;
import com.example.bookapplication.dto.BookUserResponseDto;
import com.example.bookapplication.service.BookUserService;
import com.example.bookapplication.web.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class BookUserController {

    @Autowired
    BookUserService bookUserService;

    @PostMapping()
    public ResponseEntity<?> registerUser(@RequestBody BookUserRequestDto bookUserRequestDto) {
        try{
            BookUserResponseDto responseDto = bookUserService.registerUser(bookUserRequestDto);
            return ResponseEntity.ok().body(responseDto);
        }catch(UserNotFoundException e){
            return ResponseEntity.badRequest().body(e);
        }
    }
}
