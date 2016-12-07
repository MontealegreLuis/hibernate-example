/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.hibernate.repositories;

import com.codeup.hibernate.SessionFactoryRule;
import com.codeup.hibernate.fixtures.FourMoviesFixture;
import com.codeup.movies.Movie;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class MoviesRepositoryTest {

    @Test
    public void it_finds_all_the_movies_on_a_given_category() {
        assertThat(
            movies.underCategory(FourMoviesFixture.categoryId).size(),
            is(3)
        );
    }

    @Test
    public void it_finds_no_movies_if_invalid_category_is_given() {
        int unknownCategoryId = -1;
        assertThat(movies.underCategory(unknownCategoryId).size(), is(0));
    }

    @Test
    public void it_finds_movies_with_similar_title() {
        String titleFragment = "wi";

        List<Movie> similarMovies = movies.withTitleSimilarTo(titleFragment);

        assertThat(similarMovies.size(), is(2));
        assertThat(similarMovies.get(0).title(), containsString(titleFragment));
        assertThat(similarMovies.get(1).title(), containsString(titleFragment));
    }

    @Test
    public void it_finds_no_movies_when_an_unknown_title_is_given() {
        String unknownTitle = "asdjk";
        assertThat(movies.withTitleSimilarTo(unknownTitle).size(), is(0));
    }

    @Test
    public void it_finds_a_movie_with_a_specific_id() {
        assertThat(movies.with(FourMoviesFixture.movieId), is(notNullValue()));
    }

    @Test
    public void it_does_not_find_a_movie_with_an_unknown_id() {
        int unknownMovieId = -1;
        assertThat(movies.with(unknownMovieId), is(nullValue()));
    }

    @Test
    public void it_publishes_a_new_movie() {
        Movie shrek = Movie.publish(
            "Shrek",
            5,
            "shrek.png",
            Collections.singletonList(FourMoviesFixture.animated)
        );
        movies.add(shrek);

        assertThat(movies.with(shrek.id()), is(notNullValue()));
    }

    @Before
    public void loadFixtures() {
        Session session = rule.getSession();
        FourMoviesFixture.load(session);
        movies = new MoviesRepository(session);
    }

    @Rule
    public final SessionFactoryRule rule = new SessionFactoryRule();
    private MoviesRepository movies;
}
