package com.lizgunther.videouniverse.movies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    //Here are the custom queries I wrote to pull a single random movie from my database: filtered by genre...
    @Query(nativeQuery = true, value = "SELECT * FROM moviedata m WHERE m.genre = :genre ORDER BY RAND() LIMIT 1;")
    Movie getMovieByGenre(@Param("genre") String genre);

    // ... and not filtered at all
    @Query(nativeQuery = true, value = "SELECT * FROM moviedata m ORDER BY RAND() LIMIT 1;")
    Movie getRandomMovie();

    /* This query was created to map specific movies to the home page -- allows the admin to control exactly which
        movies get featured */
    @Query(nativeQuery = true, value = "SELECT * FROM moviedata m WHERE m.id = :id")
    Movie getMovieById(@Param("id") long id);

}
