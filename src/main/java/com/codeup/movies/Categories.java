/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.movies;

import java.util.List;

public interface Categories {
    void add(Category category);
    List<Category> all();
    Category with(int id);
}
