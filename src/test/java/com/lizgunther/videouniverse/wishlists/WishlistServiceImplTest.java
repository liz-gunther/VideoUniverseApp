package com.lizgunther.videouniverse.wishlists;

import com.lizgunther.videouniverse.security.UserServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WishlistServiceImplTest {

    @Autowired
    private WishlistServiceImpl wishlistService;
    private UserServiceImpl userService;

//    @Test
//    void getWishlistsByUserId() {
//        List<Wishlist> wishlists = getWishlistsByUserId(1L);
//        Assertions.assertThat(wishlists.contains
//    }

    @Test
    void getWishlistById() {
    }
}