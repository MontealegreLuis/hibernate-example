/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.validation;

public class NumberWithinRange implements Validator<Integer> {
    private int min;
    private int max;

    public NumberWithinRange(int min, int max) {
        assertValidRange(min, max);
        this.min = min;
        this.max = max;
    }

    private void assertValidRange(int min, int max) {
        if (min > max) {
            throw  new IllegalArgumentException(String.format(
                "%d cannot be greater than %d", min, max
            ));
        }
    }

    @Override
    public boolean isValid(Integer value) {
        return min <= value && value <= max;
    }

    @Override
    public String errorMessage() {
        return String.format("Enter a number between %d and %d", min, max);
    }
}
