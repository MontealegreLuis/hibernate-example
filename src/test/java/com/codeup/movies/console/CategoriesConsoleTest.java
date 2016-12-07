/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.movies.console;

import com.codeup.console.Console;
import com.codeup.validation.NonEmptyString;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CategoriesConsoleTest {

    @Test
    public void it_accepts_a_valid_category_name() {
        String categoryName = "action";
        when(console.promptForText(anyString(), any(NonEmptyString.class)))
            .thenReturn(categoryName)
        ;
        assertThat(categoriesConsole.askForCategoryName(), is(categoryName));
    }

    @Before
    public void configureConsole() {
        categoriesConsole = new CategoriesConsole(console);
    }

    @Mock
    private Console console;
    private CategoriesConsole categoriesConsole;
}
