/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.hibernate;

import com.codeup.movies.Categories;
import com.codeup.movies.Category;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CategoriesRepository implements Categories {
    private final Session session;

    public CategoriesRepository(Session session) {
        this.session = session;
    }

    public void add(Category category) {
        session.save(category);
    }

    public List<Category> all() {
        Query query = session.createQuery("FROM Category");
        @SuppressWarnings("unchecked")
        List<Category> all = query.list();

        return all;
    }
}
