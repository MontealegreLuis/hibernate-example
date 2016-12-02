/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.validation;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

public class NonEmptyStringTest {
    @Test
    public void it_passes_if_non_empty_string_is_given() {
        assertThat(validator.isValid("Non empty message"), is(true));
    }

    @Test
    public void it_fails_if_a_string_with_only_spaces_is_given() {
        assertThat(validator.isValid("     "), is(false));
    }

    @Test
    public void it_fails_with_an_empty_string() {
        assertThat(validator.isValid(""), is(false));
    }

    @Test
    public void it_has_an_error_message() {
        assertThat(validator.errorMessage(), is(notNullValue()));
    }

    private NonEmptyString validator = new NonEmptyString();
}
