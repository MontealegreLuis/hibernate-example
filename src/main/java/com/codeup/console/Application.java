/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.console;

import com.codeup.hibernate.repositories.CategoriesRepository;
import com.codeup.hibernate.Hibernate;
import com.codeup.hibernate.repositories.MoviesRepository;
import com.codeup.movies.Category;
import com.codeup.movies.Movie;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Session session = Hibernate.openSession();

        CategoriesRepository categories = new CategoriesRepository(session);
        MoviesRepository movies = new MoviesRepository(session);

        List<Category> movieCategories = new ArrayList<Category>();
        movieCategories.add(categories.with(5));
        movieCategories.add(categories.with(6));

        Movie shrek = Movie.publish(
            "Shrek",
            5,
            "shrek.png",
            movieCategories
        );
        movies.add(shrek);

        Category category = Category.named("action");
        categories.add(category);
        List<Category> all = categories.all();

        System.out.println(String.format(
            "%d: %s",
            category.id(),
            category.name()
        ));
        System.out.println(Arrays.toString(all.toArray()));

        session.close();
    }
}
