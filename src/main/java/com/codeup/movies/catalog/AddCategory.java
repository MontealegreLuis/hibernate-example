/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.movies.catalog;

import com.codeup.console.Action;
import com.codeup.movies.Categories;
import com.codeup.movies.Category;
import com.codeup.movies.console.CategoriesConsole;

public class AddCategory {
    private final Categories categories;

    public AddCategory(Categories categories) {
        this.categories = categories;
    }

    public void withName(String name) {
        categories.add(Category.named(name));
    }
}
