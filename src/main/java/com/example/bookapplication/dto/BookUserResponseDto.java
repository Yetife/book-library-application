package com.example.bookapplication.dto;

import com.example.bookapplication.data.model.Book;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class WishListResponseDto {

    private List<Book> bookList;
}
