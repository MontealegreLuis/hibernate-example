package com.codeup.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class Hibernate {
    public static Session openSession() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure()
            .build()
        ;

        return sessionFactory(registry).openSession();
    }

    private static SessionFactory sessionFactory(StandardServiceRegistry registry) {
        return new MetadataSources(registry)
            .buildMetadata()
            .buildSessionFactory()
        ;
    }

    static Session openSession(String configurationFilePath) {
        Configuration configuration = new Configuration();
        configuration.configure(new File(configurationFilePath));
        configuration.addFile("src/main/resources/com/codeup/movies/Category.hbm.xml");
        configuration.addFile("src/main/resources/com/codeup/movies/Movie.hbm.xml");

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .applySettings(configuration.getProperties())
            .build()
        ;

        return configuration.buildSessionFactory(registry).openSession();
    }
}
