// Write your code here
package com.example.movie.repository;

import java.util.ArrayList;
import com.example.movie.model.Movie;

public interface MovieRepository {
    ArrayList<Movie> getMovies();

    Movie addMovie(Movie movie);

    Movie getById(int movieId);

    Movie updateMovie(int movieId, Movie movie);

    void deleteMovie(int movieId);

}