/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.console;

import com.codeup.hibernate.CategoriesRepository;
import com.codeup.hibernate.MoviesRepository;
import com.codeup.movies.Category;
import com.codeup.movies.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Session session = openSession();

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

    private static Session openSession() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure()
            .build()
        ;

        SessionFactory sessionFactory = new MetadataSources(registry)
            .buildMetadata()
            .buildSessionFactory()
        ;

        return sessionFactory.openSession();
    }
}
