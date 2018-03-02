/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.hibernate.repositories;

import com.codeup.movies.Movie;
import com.codeup.movies.Movies;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class MoviesRepository implements Movies {
    private final Session session;

    public MoviesRepository(Session session) {
        this.session = session;
    }

    public void add(Movie movie) {
        Transaction transaction = session.getTransaction();
        if (!transaction.isActive()) transaction.begin();
        session.save(movie);
        transaction.commit();
    }

    public Movie with(int id) {
        Query query = session.createQuery("FROM Movie WHERE id = :id");
        query.setParameter("id", id);
        query.setCacheable(true);

        return (Movie) query.uniqueResult();
    }

    @Override
    public List<Movie> withTitleSimilarTo(String title) {
        Query query = session.createQuery("FROM Movie WHERE title LIKE :title");
        query.setParameter("title", "%" + title + "%");
        query.setCacheable(true);
        query.setCacheRegion("movies.withSimilarTitle");

        @SuppressWarnings("unchecked")
        List<Movie> movies = query.getResultList();

        return movies;
    }

    @Override
    public List<Movie> underCategory(int categoryId) {
        Query query = session.createQuery(
            "SELECT m FROM Movie m JOIN m.categories c WHERE c.id = :category"
        );
        query.setParameter("category", categoryId);
        query.setCacheable(true);
        query.setCacheRegion("movies.underCategory");

        @SuppressWarnings("unchecked")
        List<Movie> movies = query.getResultList();

        return movies;
    }
}
