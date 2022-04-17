package com.lizgunther.videouniverse.movies;

public interface MovieService {

    Movie getMovieByGenre(String genre);

    Movie getRandomMovie();

    Movie getMovieById(long id);

}
