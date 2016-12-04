/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.hibernate.repositories;

import com.codeup.hibernate.SessionFactoryRule;
import com.codeup.hibernate.fixtures.FourCategoriesFixture;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CategoriesRepositoryTest {
    @Test
    public void it_loads_all_the_available_categories() {
        assertThat(categories.all().size(), is(4));
    }

    @Before
    public void loadFixtures() {
        session = rule.getSession();
        FourCategoriesFixture.load(session);
        categories = new CategoriesRepository(session);
    }

    @Rule
    public final SessionFactoryRule rule = new SessionFactoryRule();
    private Session session;
    private CategoriesRepository categories;
}
