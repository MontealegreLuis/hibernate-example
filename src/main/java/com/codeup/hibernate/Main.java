/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.hibernate;

import com.codeup.movies.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = openSession();

        CategoriesRepository categories = new CategoriesRepository(session);

        Category category = Category.named("action");
        categories.add(category);
        List<Category> all = categories.all();

        System.out.println(MessageFormat.format(
            "{0}: {1}",
            category.getId(),
            category.getName()
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
