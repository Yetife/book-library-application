package com.example.bookapplication.dto;

import lombok.Data;

@Data
public class BookUserRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;

}
