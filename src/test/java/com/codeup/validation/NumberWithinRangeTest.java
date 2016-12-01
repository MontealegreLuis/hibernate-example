/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.validation;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class NumberWithinRangeTest {
    private static final int MIN = 1;
    private static final int MAX = 4;
    private static final int VALID = 2;
    private NumberWithinRange validator;

    @Test(expected = IllegalArgumentException.class)
    public void it_is_not_created_if_invalid_range_is_given() {
        new NumberWithinRange(4, 2);
    }

    @Test
    public void it_passes_if_number_within_range_is_given() {
        validator = new NumberWithinRange(MIN, MAX);

        assertThat(validator.isValid(VALID), is(true));
    }

    @Test
    public void it_passes_if_number_is_equal_to_minimum_value() {
        validator = new NumberWithinRange(MIN, MAX);

        assertThat(validator.isValid(MIN), is(true));
    }

    @Test
    public void it_passes_if_number_is_equal_to_maximum_value() {
        validator = new NumberWithinRange(MIN, MAX);

        assertThat(validator.isValid(MAX), is(true));
    }

    @Test
    public void it_fails_if_number_is_less_than_minimum_value() {
        validator = new NumberWithinRange(MIN, MAX);

        assertThat(validator.isValid(MIN - 1), is(false));
    }

    @Test
    public void it_fails_if_number_is_greater_than_maximum_value() {
        validator = new NumberWithinRange(MIN, MAX);

        assertThat(validator.isValid(MAX + 1), is(false));
    }

    @Test
    public void it_fails_with_negative_range() {
        validator = new NumberWithinRange(-MAX, -MIN);

        assertThat(validator.isValid(-MAX - 1), is(false));
    }

    @Test
    public void it_passes_with_negative_range() {
        validator = new NumberWithinRange(-MAX, -MIN);

        assertThat(validator.isValid(-VALID), is(true));
    }
}
