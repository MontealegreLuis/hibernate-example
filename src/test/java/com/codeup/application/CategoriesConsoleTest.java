/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.application;

import com.codeup.console.Console;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CategoriesConsoleTest {
    @Test
    public void it_accepts_a_valid_category_name() {
        console = aConsoleWithInput(categoryName);

        assertThat(console.askForCategoryName(), is(equalTo(categoryName)));
    }

    @Test
    public void it_keeps_prompting_until_a_valid_name_is_given() {
        console = aConsoleWithInput(emptyText, emptyText, categoryName);

        assertThat(console.askForCategoryName(), is(equalTo(categoryName)));
    }

    private CategoriesConsole aConsoleWithInput(String... userInput) {
        ByteArrayInputStream input = new ByteArrayInputStream(
            String.join("\n", userInput).getBytes()
        );
        return new CategoriesConsole(new Console(
            new Scanner(input).useDelimiter("\n"),
            output
        ));
    }

    private CategoriesConsole console;

    private final String categoryName = "action";
    private final String emptyText = "    ";

    @Mock
    private PrintStream output;
}
