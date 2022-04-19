package com.lizgunther.videouniverse.movies;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieServiceImplTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    void getMovieById_should_return_Movie_with_certain_id() {
        Movie movie = movieRepository.getMovieById(1);
        Assertions.assertThat(movie.getId()).isEqualTo(1);
    }
}