package com.codeup.movies.catalog;

import com.codeup.console.Action;
import com.codeup.movies.Categories;
import com.codeup.movies.Movie;
import com.codeup.movies.Movies;
import com.codeup.movies.console.MoviesConsole;

public class AddMovie implements Action {
    private final Categories categories;
    private final Movies movies;
    private final MoviesConsole console;

    public AddMovie(
        Categories categories,
        Movies movies,
        MoviesConsole console
    ) {
        this.categories = categories;
        this.movies = movies;
        this.console = console;
    }

    public void execute() {
        Movie movie = Movie.publish(
            console.askForMovieTitle(),
            console.askForMovieRating(),
            console.askForThumbnail(),
            console.chooseCategories(categories.all())
        );
        movies.add(movie);
    }
}