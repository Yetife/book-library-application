package com.example.bookapplication.dto;

import com.example.bookapplication.data.model.BookStatus;
import lombok.Data;

@Data
public class BookDtoRequest {
    private String title;
    private String author;
    private int yearOfPublishing;
    private String imageUrl;
    private BookStatus bookStatus;
}
