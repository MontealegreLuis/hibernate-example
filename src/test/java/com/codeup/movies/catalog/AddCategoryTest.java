/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.movies.catalog;

import com.codeup.movies.Categories;
import com.codeup.movies.Category;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AddCategoryTest {
    @Test
    public void it_adds_a_new_category() {
        addCategory.withName("action");

        verify(categories).add(any(Category.class));
    }

    @Before
    public void configureCommand() {
        addCategory = new AddCategory(categories);
    }

    private AddCategory addCategory;

    @Mock
    Categories categories;
}
