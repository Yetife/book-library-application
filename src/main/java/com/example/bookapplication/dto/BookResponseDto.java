package com.example.bookapplication.dto;

import lombok.Data;

@Data
public class BookResponseDto {
    private String volumeInfo;
    private String publishDate;
    private String description;
    private int pageCount;
    private String imageLink;
}
