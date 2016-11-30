/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.movies.console.actions;

import com.codeup.console.Action;
import com.codeup.movies.Categories;
import com.codeup.movies.Category;
import com.codeup.movies.Movie;
import com.codeup.movies.catalog.SearchByCategory;
import com.codeup.movies.console.MoviesConsole;

import java.util.List;

public class SearchByCategoryAction implements Action {
    private SearchByCategory searchMovies;
    private MoviesConsole console;
    private Categories categories;

    public SearchByCategoryAction(
        SearchByCategory searchMovies,
        MoviesConsole console,
        Categories categories
    ) {
        this.searchMovies = searchMovies;
        this.console = console;
        this.categories = categories;
    }

    @Override
    public void execute() {
        Category chosenCategory = console.chooseACategoryFrom(categories.all());
        List<Movie> movies = searchMovies.inCategory(chosenCategory.id());
        console.showMovies(movies);
    }
}
