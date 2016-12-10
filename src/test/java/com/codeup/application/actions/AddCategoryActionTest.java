/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.application.actions;

import com.codeup.application.CategoriesConsole;
import com.codeup.movies.catalog.AddCategory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AddCategoryActionTest {
    @Test
    public void it_adds_a_new_category() {
        String newCategory = "action";
        when(console.askForCategoryName()).thenReturn(newCategory);

        action.execute();

        verify(addCategory).withName(newCategory);
    }

    @Before
    public void configureAction() {
        action = new AddCategoryAction(addCategory, console);
    }

    private AddCategoryAction action;

    @Mock
    private AddCategory addCategory;

    @Mock
    private CategoriesConsole console;
}
