/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.movies.catalog;

import com.codeup.movies.Movie;
import com.codeup.movies.Movies;

import java.util.List;

public class SearchByCategory {
    private Movies movies;

    public SearchByCategory(Movies movies) {
        this.movies = movies;
    }

    public List<Movie> inCategory(int categoryId) {
        return movies.underCategory(categoryId);
    }
}
