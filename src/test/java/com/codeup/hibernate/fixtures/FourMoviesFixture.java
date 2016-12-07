/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.hibernate.fixtures;

import com.codeup.movies.Category;
import com.codeup.movies.Movie;
import org.hibernate.Session;

import java.util.Arrays;
import java.util.Collections;

public class FourMoviesFixture {
    public static int categoryId;
    public static int movieId;
    public static Category animated;

    public static void load(Session session) {
        Category drama = Category.named("drama");
        Category musical = Category.named("musical");
        Category animated = Category.named("animated");
        FourMoviesFixture.animated = animated;

        session.save(drama);
        categoryId = drama.id();
        session.save(musical);
        session.save(animated);

        Movie casablanca = Movie.publish(
            "Casablanca",
            4,
            "casablanca.png",
            Collections.singletonList(drama)
        );
        session.save(casablanca);
        movieId = casablanca.id();
        session.save(Movie.publish(
            "The wizard of Oz",
            4,
            "oz.gif",
            Collections.singletonList(musical)
        ));
        session.save(Movie.publish(
            "Snow White And The Seven Dwarfs",
            3,
            "snow_white.png",
            Arrays.asList(animated, drama)
        ));
        session.save(Movie.publish(
            "Gone with the wind",
            4,
            "wind.png",
            Collections.singletonList(drama)
        ));
    }
}
