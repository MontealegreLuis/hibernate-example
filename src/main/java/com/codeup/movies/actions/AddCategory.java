/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.movies.actions;

import com.codeup.console.Action;
import com.codeup.movies.Categories;
import com.codeup.movies.Category;

public class AddCategory implements Action {
    private final Categories categories;
    private final CategoriesConsole console;

    public AddCategory(Categories categories, CategoriesConsole console) {
        this.categories = categories;
        this.console = console;
    }

    @Override
    public void execute() {
        categories.add(Category.named(console.askForCategoryName()));
    }
}
