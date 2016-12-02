/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.validation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class IntegerFromStringTest {
    private IntegerFromString validator;

    @Mock
    private Validator<Integer> integerValidator;

    @Before
    public void createValidator() {
        validator = new IntegerFromString(integerValidator);
    }

    @Test
    public void it_fails_if_text_is_provided() {
        String notANumber = "this is not a number";

        assertThat(validator.isValid(notANumber), is(false));
        verify(integerValidator, never()).isValid(anyInt());
    }

    @Test
    public void it_fails_if_empty_text_is_provided() {
        String emptyText = "       ";

        assertThat(validator.isValid(emptyText), is(false));
        verify(integerValidator, never()).isValid(anyInt());
    }

    @Test
    public void it_calls_integer_validator_if_input_can_be_converted_to_string() {
        String aNumericString = "100";
        int aNumber = 100;
        when(integerValidator.isValid(aNumber)).thenReturn(true);

        assertThat(validator.isValid(aNumericString), is(true));
    }

    @Test
    public void it_uses_integer_validator_message_if_validation_fails() {
        String aNumericString = "100";
        int aNumber = 100;
        String integerValidationMessage = "Integer error message";

        when(integerValidator.isValid(aNumber)).thenReturn(false);
        when(integerValidator.errorMessage()).thenReturn(integerValidationMessage);

        validator.isValid(aNumericString);

        assertThat(validator.errorMessage(), is(integerValidationMessage));
    }
}
