package com.lizgunther.videouniverse.movies;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "moviedata")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String year;
    private String genre;
    @Column(name = "trailer_link")
    private String trailerLink;
    @Column(name = "poster_link")
    private String posterLink;
    private String description;
    @Column(name = "imdbId")
    private String imdbId;
//

    public Movie() {
    }

    public Movie(long id, String title, String year, String genre, String trailerLink, String posterLink, String description, String imdbId) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.trailerLink = trailerLink;
        this.posterLink = posterLink;
        this.description = description;
        this.imdbId = imdbId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTrailerLink() {
        return trailerLink;
    }

    public void setTrailerLink(String trailerLink) {
        this.trailerLink = trailerLink;
    }

    public String getPosterLink() {
        return posterLink;
    }

    public void setPosterLink(String posterLink) {
        this.posterLink = posterLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id && Objects.equals(title, movie.title) && Objects.equals(year, movie.year) && Objects.equals(genre, movie.genre) && Objects.equals(trailerLink, movie.trailerLink) && Objects.equals(posterLink, movie.posterLink) && Objects.equals(description, movie.description) && Objects.equals(imdbId, movie.imdbId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, year, genre, trailerLink, posterLink, description, imdbId);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", genre='" + genre + '\'' +
                ", trailerLink='" + trailerLink + '\'' +
                ", posterLink='" + posterLink + '\'' +
                ", description='" + description + '\'' +
                ", imdbId='" + imdbId + '\'' +
                '}';
    }
}
