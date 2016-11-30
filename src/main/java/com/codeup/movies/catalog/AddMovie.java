package com.codeup.movies.catalog;

import com.codeup.movies.Category;
import com.codeup.movies.Movie;
import com.codeup.movies.Movies;

import java.util.List;

public class AddMovie {
    private final Movies movies;

    public AddMovie(Movies movies) {
        this.movies = movies;
    }

    public void withDetails(
        String title,
        int rating,
        String thumbnail,
        List<Category> categories
    ) {
        Movie movie = Movie.publish(
            title,
            rating,
            thumbnail,
            categories
        );
        movies.add(movie);
    }
}
