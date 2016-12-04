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
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
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

    @Test
    public void it_accepts_text_that_can_be_converted_to_integer() {
        when(validator.isValid(numericText)).thenReturn(true);
        console = new Console(getInput(numericText), output);

        assertThat(console.promptForInteger(message, validator), is(number));
    }

    @Test
    public void it_prompts_a_second_time_if_invalid_numeric_text_is_given() {
        when(validator.isValid(invalidText)).thenReturn(false);
        when(validator.isValid(numericText)).thenReturn(true);
        console = new Console(
            getInput(String.format("%s\n%s", invalidText, numericText)),
            output
        );

        assertThat(console.promptForInteger(message, validator), is(number));
        verify(validator).errorMessage();
    }

    @Test
    public void it_accepts_a_valid_option_within_a_list() {
        console = new Console(
            getInput(validListOption),
            output
        );

        assertThat(console.chooseFromList(message, options), is(optionChosen));
    }

    @Test
    public void it_prompts_a_second_time_if_invalid_list_option_is_given() {
        console = new Console(
            getInput(String.format("%s\n%s", invalidText, validListOption)),
            output
        );

        assertThat(console.chooseFromList(message, options), is(optionChosen));
    }

    @Test
    public void it_executes_action_twice_if_answer_to_question_is_no_the_second_time() {
        console = new Console(
            getInput(String.format("%s\n%s", yes, no)),
            output
        );

        console.askYesNoQuestion(message, action);
        verify(action, times(2)).execute();
    }

    @Test
    public void it_prints_a_given_message() {
        console = new Console(
            getInput("no input needed"),
            output
        );

        console.message(message);
        verify(output).println(message);
    }

    private Scanner getInput(String text) {
        return new Scanner(new ByteArrayInputStream(text.getBytes()))
            .useDelimiter("\n")
        ;
    }

    private Console console;
    private String message = "Message";
    private String yes = "y";
    private String no = "n";
    private List<String> options = Arrays.asList(
        new String[]{"Option1", "Option2", "Option3"}
    );
    private int optionChosen = 1;
    private String validListOption = "2";
    private int number = 367;
    private String numericText = "367";
    private String invalidText = "invalid";
    private String text = "text";

    @Mock
    private Action action;

    @Mock
    private PrintStream output;

    @Mock
    private Validator validator;
}
