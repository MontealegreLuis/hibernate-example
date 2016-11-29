package com.codeup.movies.actions;

import com.codeup.console.Action;
import com.codeup.console.MoviesConsole;
import com.codeup.movies.Categories;
import com.codeup.movies.Movie;
import com.codeup.movies.Movies;

public class AddMovieAction implements Action {
    private final Categories categories;
    private final Movies movies;
    private final MoviesConsole console;

    public AddMovieAction(
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
