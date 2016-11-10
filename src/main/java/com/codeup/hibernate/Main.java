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

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure()
            .build()
        ;

        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.save(Category.named("action"));
        session.close();
    }
}
