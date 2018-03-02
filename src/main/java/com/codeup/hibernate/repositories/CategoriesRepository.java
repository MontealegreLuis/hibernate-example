/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.hibernate.repositories;

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

    public Category with(int id) {
        Query query = session.createQuery("FROM Category WHERE id = :id");
        query.setParameter("id", id);
        query.setCacheable(true);

        return (Category) query.uniqueResult();
    }

    public List<Category> all() {
        Query query = session.createQuery("FROM Category");
        query.setCacheable(true);
        query.setCacheRegion("movies.categories");

        @SuppressWarnings("unchecked")
        List<Category> all = query.list();

        return all;
    }
}
