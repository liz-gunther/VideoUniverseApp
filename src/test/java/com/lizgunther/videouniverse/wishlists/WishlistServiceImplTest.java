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

    @Test
    void getWishlistById_should_return_specific_wishlist_when_id_is_provided() {
        Wishlist wishlist = wishlistService.getWishlistById(1);
        Assertions.assertThat(wishlist.getId()).isEqualTo(1);
    }
}