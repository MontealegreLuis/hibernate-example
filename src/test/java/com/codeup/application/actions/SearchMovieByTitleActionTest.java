/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.application.actions;

import com.codeup.application.MoviesConsole;
import com.codeup.movies.Category;
import com.codeup.movies.Movie;
import com.codeup.movies.catalog.SearchMovieByTitle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SearchMovieByTitleActionTest {
    @Test
    public void it_shows_movies_with_similar_titles() {
        String titleFragment = "wi";
        when(console.askForMovieTitle()).thenReturn(titleFragment);
        when(searchMovie.withSimilarTitle(titleFragment)).thenReturn(movies);

        action.execute();

        verify(console).showMovies(movies);
    }

    @Before
    public void configureAction() {
        Category animated = Category.named("animated");
        movies = new ArrayList<>();
        movies.add(Movie.publish(
            "The wizard of Oz",
            5,
            "wizard.png",
            Collections.singletonList(animated)
        ));
        movies.add(Movie.publish(
            "Gone with the wind",
            4,
            "wind.png",
            Collections.singletonList(animated)
        ));
        action = new SearchMovieByTitleAction(searchMovie, console);
    }

    private SearchMovieByTitleAction action;

    private List<Movie> movies;

    @Mock
    private SearchMovieByTitle searchMovie;

    @Mock
    private MoviesConsole console;
}
