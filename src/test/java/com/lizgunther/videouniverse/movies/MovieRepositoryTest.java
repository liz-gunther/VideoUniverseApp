package com.lizgunther.videouniverse.movies;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    void getMovieByGenre_should_return_Movie_where_genre_is_horror() {
        Movie horrorMovie = movieRepository.getMovieByGenre("horror");
        Assertions.assertThat(horrorMovie.getGenre()).isEqualTo("horror");
    }

    @Test
    void getRandomMovie_should_return_Movie_where_id_is_valid() {
        Movie randomMovie = movieRepository.getRandomMovie();
        Assertions.assertThat(randomMovie.getId()).isBetween(1L, 2L);
    }

    @Test
    void getMovieById_should_return_valid_Movie_id() {
        Movie horrorMovie = movieRepository.getMovieById(1);
        Assertions.assertThat(horrorMovie.getId()).isEqualTo(1);
    }
}