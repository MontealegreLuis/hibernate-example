/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.movies.console.actions;

import com.codeup.console.Action;
import com.codeup.movies.catalog.SearchMovieByTitle;
import com.codeup.movies.console.MoviesConsole;

public class SearchMovieByTitleAction implements Action {
    private final SearchMovieByTitle searchMovie;
    private final MoviesConsole console;

    public SearchMovieByTitleAction(
        SearchMovieByTitle searchMovie,
        MoviesConsole console
    ) {
        this.searchMovie = searchMovie;
        this.console = console;
    }

    @Override
    public void execute() {
        console.showMovies(searchMovie.withSimilarTitle(console.askForMovieTitle()));
    }
}
