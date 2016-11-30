/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.validation;

public class NonEmptyString implements Validator<String> {
    @Override
    public boolean isValid(String value) {
        return !value.trim().isEmpty();
    }

    @Override
    public String errorMessage() {
        return "This value cannot be empty";
    }
}
