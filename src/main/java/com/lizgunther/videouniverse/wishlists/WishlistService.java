package com.lizgunther.videouniverse.wishlists;

import com.lizgunther.videouniverse.movies.Movie;

import java.util.Set;


public interface WishlistService {

    void saveToWishlist(Wishlist wishlist);

    Set<Wishlist> getWishlistsByUserId(long id);

    Wishlist getWishlistById(long id);

    void saveWishlist(Wishlist wishlist);

    void deleteWishlistById(long id);

    Wishlist getWishlistByUserId(long id);

    void deleteMovieFromWishlist(long id, Movie movie);


}
