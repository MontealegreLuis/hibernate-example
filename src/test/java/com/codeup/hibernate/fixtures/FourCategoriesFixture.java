/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.hibernate.fixtures;

import com.codeup.movies.Category;
import org.hibernate.Session;

public class FourCategoriesFixture {
    public static int categoryId;

    public static void load(Session session) {
        session.save(Category.named("action"));
        session.save(Category.named("horror"));
        session.save(Category.named("drama"));
        Category existingCategory = Category.named("animated");
        session.save(existingCategory);
        categoryId = existingCategory.id();
    }
}
