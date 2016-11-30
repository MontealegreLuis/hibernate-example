/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.movies.console.actions;

import com.codeup.console.Action;
import com.codeup.movies.Categories;
import com.codeup.movies.catalog.AddMovie;
import com.codeup.movies.console.MoviesConsole;

public class AddMovieAction implements Action {
    private final AddMovie addMovie;
    private final MoviesConsole console;
    private final Categories categories;

    public AddMovieAction(
        AddMovie addMovie,
        MoviesConsole console,
        Categories categories
    ) {
        this.addMovie = addMovie;
        this.console = console;
        this.categories = categories;
    }

    @Override
    public void execute() {
        addMovie.withDetails(
            console.askForMovieTitle(),
            console.askForMovieRating(),
            console.askForThumbnail(),
            console.chooseCategories(categories.all())
        );
    }
}
