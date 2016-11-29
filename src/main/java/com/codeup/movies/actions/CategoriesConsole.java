/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.movies.actions;

import com.codeup.console.Console;

public class CategoriesConsole {
    private final Console console;

    public CategoriesConsole(Console console) {
        this.console = console;
    }

    String askForCategoryName() {
        return console.promptForNonEmptyText("Category name: ");
    }
}
