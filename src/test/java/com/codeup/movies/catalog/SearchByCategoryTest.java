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
public class SearchByCategoryTest {
    @Test
    public void it_filters_movies_by_category_id() {
        int categoryId = 10;
        searchByCategory.inCategory(categoryId);

        verify(movies).underCategory(categoryId);
    }

    @Before
    public void configureCommand() {
        searchByCategory = new SearchByCategory(movies);
    }

    private SearchByCategory searchByCategory;

    @Mock
    private Movies movies;
}
