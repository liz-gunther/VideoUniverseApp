package com.lizgunther.videouniverse.wishlists;

import com.lizgunther.videouniverse.movies.Movie;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "wishlist")
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Wishlist_Movie",
            joinColumns = {@JoinColumn(name = "wishlist_id")},
            inverseJoinColumns = {@JoinColumn(name = "movie_id")}
    )
    private Set<Movie> movies = new HashSet<>();
    private String wishlistName;

    public Wishlist() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public String getWishlistName() {
        return wishlistName;
    }

    public void setWishlistName(String wishlistName) {
        this.wishlistName = wishlistName;
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "id=" + id +
                ", movies=" + movies +
                ", wishlistName='" + wishlistName + '\'' +
                '}';
    }

    public void setUserId(long id) {
    }
}
