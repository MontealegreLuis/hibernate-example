/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.movies.catalog;

import com.codeup.movies.Movies;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SearchMovieByTitleTest {
    @Test
    public void it_filters_movies_by_similar_titles() {
        String title = "on";
        searchMovieByTitle.withSimilarTitle(title);

        verify(movies).withTitleSimilarTo(title);
    }

    @Before
    public void configureCommand() {
        searchMovieByTitle = new SearchMovieByTitle(movies);
    }

    private SearchMovieByTitle searchMovieByTitle;

    @Mock
    Movies movies;
}
