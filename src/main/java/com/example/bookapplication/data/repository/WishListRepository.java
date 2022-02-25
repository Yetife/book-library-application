package com.example.bookapplication.data.repository;

import com.example.bookapplication.data.model.UserWishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListRepository extends JpaRepository<UserWishList, Long> {

}
