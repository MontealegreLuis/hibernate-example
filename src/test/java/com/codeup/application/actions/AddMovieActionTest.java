/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.application.actions;

import com.codeup.application.MoviesConsole;
import com.codeup.movies.Categories;
import com.codeup.movies.Category;
import com.codeup.movies.catalog.AddMovie;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AddMovieActionTest {
    @Test
    public void it_adds_a_new_movie() {
        String title = "Casablanca";
        int rating = 5;
        String thumbnail = "casablanca.png";

        when(categories.all()).thenReturn(allCategories);
        when(console.askForMovieTitle()).thenReturn(title);
        when(console.askForMovieRating()).thenReturn(rating);
        when(console.askForThumbnail()).thenReturn(thumbnail);
        when(console.chooseCategories(allCategories)).thenReturn(selectedCategories);

        action.execute();

        verify(addMovie).withDetails(title, rating, thumbnail, selectedCategories);
    }

    @Before
    public void configureAction() {
        Category drama = Category.named("drama");
        Category musical = Category.named("musical");
        Category animated = Category.named("animated");
        allCategories = Arrays.asList(drama, musical, animated);
        selectedCategories = Collections.singletonList(drama);
        action = new AddMovieAction(addMovie, console, categories);
    }

    private AddMovieAction action;

    private List<Category> allCategories;
    private List<Category> selectedCategories;

    @Mock
    private AddMovie addMovie;

    @Mock
    private MoviesConsole console;

    @Mock
    private Categories categories;
}
