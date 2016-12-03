/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.console;

import com.codeup.validation.Validator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleTest {
    @Test
    public void it_accepts_a_valid_text() {
        when(validator.isValid(text)).thenReturn(true);
        console = new Console(getInput(text), output);

        assertThat(console.promptForText(message, validator), is(text));
    }

    @Test
    public void it_prompts_a_second_time_if_invalid_text_is_given() {
        when(validator.isValid(invalidText)).thenReturn(false);
        when(validator.isValid(text)).thenReturn(true);
        console = new Console(
            getInput(String.format("%s\n%s", invalidText, text)),
            output
        );

        assertThat(console.promptForText(message, validator), is(text));
        verify(validator).errorMessage();
    }

    private Scanner getInput(String text) {
        return new Scanner(new ByteArrayInputStream(text.getBytes()))
            .useDelimiter("\n")
        ;
    }

    private Console console;
    private String message = "Message";
    private String invalidText = "invalid";
    private String text = "text";

    @Mock
    private PrintStream output;

    @Mock
    private Validator validator;
}
