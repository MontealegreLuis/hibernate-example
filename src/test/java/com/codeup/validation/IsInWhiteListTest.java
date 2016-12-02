/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.validation;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

public class IsInWhiteListTest {
    @Test
    public void it_passes_if_value_is_in_whitelist() {
        assertThat(validator.isValid("in the list"), is(true));
    }

    @Test
    public void it_fails_when_value_is_not_in_the_whitelist() {
        assertThat(validator.isValid("not in list"), is(false));
    }

    @Test
    public void it_has_an_error_message() {
        assertThat(validator.errorMessage(), is(notNullValue()));
    }

    private IsInWhiteList validator = new IsInWhiteList("a", "in the list", "c");
}
