package com.example.bookapplication.dto;

import lombok.Data;

@Data
public class WishListRequestDto {

    private Long BookId;
    private String Title;
    private Long userId;
}
