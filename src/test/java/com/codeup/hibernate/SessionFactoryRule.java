/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

public class SessionFactoryRule implements MethodRule {
    private Transaction transaction;
    private Session session;

    @Override
    public Statement apply(
        final Statement statement,
        FrameworkMethod method,
        Object test
    ) {

        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
            session = Hibernate.openSession(
                "src/test/resources/hibernate.test.cfg.xml"
            );
            transaction = session.beginTransaction();

            try {
                statement.evaluate();
            } finally {
                shutdown();
            }
            }

        };
    }

    private void shutdown() {
        try {
            try {
                try {
                    if (transaction.isActive()) transaction.rollback();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                session.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Session getSession() {
        return session;
    }
}
