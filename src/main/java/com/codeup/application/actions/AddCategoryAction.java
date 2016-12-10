/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.application.actions;

import com.codeup.console.Action;
import com.codeup.movies.catalog.AddCategory;
import com.codeup.application.CategoriesConsole;

public class AddCategoryAction implements Action {
    private final AddCategory addCategory;
    private final CategoriesConsole console;

    public AddCategoryAction(AddCategory addCategory, CategoriesConsole console) {
        this.addCategory = addCategory;
        this.console = console;
    }

    @Override
    public void execute() {
        addCategory.withName(console.askForCategoryName());
    }
}
