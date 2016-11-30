/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.validation;

public class IsInteger implements Validator<String> {
    @Override
    public boolean isValid(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return false;
    }

    @Override
    public String errorMessage() {
        return "Enter an integer number";
    }
}
