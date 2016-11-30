/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.movies;

import java.util.List;

public interface Movies {
    void add(Movie movie);
    Movie with(int id);
    List<Movie> withTitleSimilarTo(String title);
    List<Movie> underCategory(int categoryId);
}
