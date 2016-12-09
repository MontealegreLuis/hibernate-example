/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.movies.catalog;

import com.codeup.movies.Movie;
import com.codeup.movies.Movies;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AddMovieTest {

    @Test
    public void it_adds_a_new_movie() {
        addMovie.withDetails("Home", 4, "home.png", Collections.emptyList());

        verify(movies).add(any(Movie.class));
    }

    @Before
    public void configureCommand() {
        addMovie = new AddMovie(movies);
    }

    private AddMovie addMovie;

    @Mock
    Movies movies;
}
