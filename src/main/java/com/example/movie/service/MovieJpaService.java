/*
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 *
 */

// Write your code here
package com.example.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;

import com.example.movie.repository.MovieJpaRepository;
import com.example.movie.repository.MovieRepository;
import com.example.movie.model.Movie;

@Service
public class MovieJpaService implements MovieRepository {

    @Autowired
    private MovieJpaRepository moviejparepository;

    @Override
    public ArrayList<Movie> getMovies() {
        List<Movie> list = moviejparepository.findAll();
        ArrayList<Movie> arraylist = new ArrayList<>(list);
        return arraylist;
    }

    @Override

    public Movie getById(int movieId) {
        try {
            Movie movie1 = moviejparepository.findById(movieId).get();
            return movie1;

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }

    }

    @Override

    public Movie addMovie(Movie movie) {
        moviejparepository.save(movie);
        return movie;
    }

    @Override

    public Movie updateMovie(int movieId, Movie movie) {
        try {
            Movie movie2 = moviejparepository.findById(movieId).get();
            if (movie.getMovieName() != null) {
                movie2.setMovieName(movie.getMovieName());
            }
            if (movie.getLeadActor() != null) {
                movie2.setLeadActor(movie.getLeadActor());
            }
            moviejparepository.save(movie2);
            return movie2;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }

    }

    @Override

    public void deleteMovie(int movieId) {
        try {
            moviejparepository.deleteById(movieId);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
