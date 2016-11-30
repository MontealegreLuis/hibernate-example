/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.movies.catalog;

import com.codeup.console.Action;
import com.codeup.movies.Movies;
import com.codeup.movies.console.MoviesConsole;

public class SearchMovieByTitle implements Action {
    private final Movies movies;
    private final MoviesConsole console;

    public SearchMovieByTitle(Movies movies, MoviesConsole console) {
        this.movies = movies;
        this.console = console;
    }

    @Override
    public void execute() {
        String title = console.askForMovieTitle();
        console.showMovies(movies.withTitleSimilarTo(title));
    }
}
