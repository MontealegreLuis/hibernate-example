/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.validation;

import java.util.Arrays;

public class IsInWhiteList implements Validator<String> {
    private final String[] whiteList;

    public IsInWhiteList(String... whiteList) {
        this.whiteList = whiteList;
    }

    @Override
    public boolean isValid(String value) {
        return Arrays.binarySearch(whiteList, value) != -1;
    }

    @Override
    public String errorMessage() {
        return String.format(
            "Enter a valid option like: %s",
            Arrays.toString(whiteList)
        );
    }
}
