/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.hibernate.repositories;

import com.codeup.movies.Movie;
import com.codeup.movies.Movies;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class MoviesRepository implements Movies {
    private final Session session;

    public MoviesRepository(Session session) {
        this.session = session;
    }

    public void add(Movie movie) {
        session.beginTransaction();
        session.save(movie);
        session.getTransaction().commit();
    }

    public Movie with(int id) {
        Query query = session.createQuery("FROM Movie WHERE id = ?");
        query.setParameter(0, id);

        return (Movie) query.uniqueResult();
    }

    @Override
    public List<Movie> withTitleSimilarTo(String title) {
        Query query = session.createQuery("FROM Movie WHERE title LIKE ?");
        query.setParameter(0, title);

        @SuppressWarnings("unchecked")
        List movies = query.getResultList();

        return movies;
    }
}
