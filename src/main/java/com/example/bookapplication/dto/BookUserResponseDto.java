package com.example.bookapplication.dto;

import com.example.bookapplication.data.model.Book;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BookUserResponseDto {
    private String firstName;
    private String lastName;
    private String email;
    private String address;
}
