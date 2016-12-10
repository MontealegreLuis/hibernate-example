/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.application.actions;

import com.codeup.application.MoviesConsole;
import com.codeup.movies.Categories;
import com.codeup.movies.Category;
import com.codeup.movies.Movie;
import com.codeup.movies.catalog.SearchByCategory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SearchByCategoryActionTest {
    @Test
    public void it_shows_the_movies_in_a_given_category() {
        int defaultId = 0;
        when(categories.all()).thenReturn(allCategories);
        when(console.chooseACategoryFrom(allCategories)).thenReturn(animated);
        when(searchMovies.inCategory(defaultId)).thenReturn(movies);

        action.execute();

        verify(console).showMovies(movies);
    }

    @Before
    public void configureAction() {
        Category drama = Category.named("drama");
        Category musical = Category.named("musical");
        animated = Category.named("animated");
        allCategories = Arrays.asList(drama, musical, animated);

        movies = new ArrayList<>();
        movies.add(Movie.publish("Shrek", 5, "shrek.png", Collections.singletonList(animated)));
        movies.add(Movie.publish("Home", 4, "home.png", Collections.singletonList(animated)));

        action = new SearchByCategoryAction(searchMovies, console, categories);
    }

    private SearchByCategoryAction action;

    private List<Category> allCategories;
    private Category animated;
    private List<Movie> movies;

    @Mock
    private SearchByCategory searchMovies;

    @Mock
    private MoviesConsole console;

    @Mock
    private Categories categories;
}
