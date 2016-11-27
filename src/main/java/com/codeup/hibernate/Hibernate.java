package com.codeup.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Hibernate {
    public static Session openSession() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure()
            .build();

        SessionFactory sessionFactory = new MetadataSources(registry)
            .buildMetadata()
            .buildSessionFactory();

        return sessionFactory.openSession();
    }
}
