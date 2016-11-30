/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.validation;

public class IntegerFromString implements Validator<String> {
    private Validator<Integer> validator;
    private String errorMessage = "Enter an integer number";

    public IntegerFromString(Validator<Integer> validator) {
        this.validator = validator;
    }

    @Override
    public boolean isValid(String value) {
        int number;
        try {
            number = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }

        boolean isValid = validator.isValid(number);
        if (!isValid) {
            errorMessage = validator.errorMessage();
        }

        return isValid;
    }

    @Override
    public String errorMessage() {
        return errorMessage;
    }
}
