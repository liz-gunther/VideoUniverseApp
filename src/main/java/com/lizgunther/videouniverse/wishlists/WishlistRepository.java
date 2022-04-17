package com.lizgunther.videouniverse.wishlists;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

//    Set<Wishlist> getByUserId(long userId);

    Wishlist getById(long id);


//    Wishlist getWishlistByUserId(long userid);


}
