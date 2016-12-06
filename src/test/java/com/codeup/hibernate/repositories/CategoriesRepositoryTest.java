/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.hibernate.repositories;

import com.codeup.hibernate.SessionFactoryRule;
import com.codeup.hibernate.fixtures.FourCategoriesFixture;
import com.codeup.movies.Category;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

public class CategoriesRepositoryTest {
    @Test
    public void it_loads_all_the_available_categories() {
        assertThat(categories.all().size(), is(4));
    }

    @Test
    public void it_adds_a_new_category() {
        Category newCategory = Category.named("thriller");

        categories.add(newCategory);
        List<Category> allCategories = categories.all();

        assertThat(allCategories.size(), is(5));
        assertThat(allCategories.contains(newCategory), is(true));
    }

    @Test
    public void it_finds_an_existing_category_by_its_id() {
        System.out.println(FourCategoriesFixture.categoryId);
        assertThat(
            categories.with(FourCategoriesFixture.categoryId),
            is(notNullValue())
        );
    }

    @Test
    public void it_fails_to_retrieve_a_category_with_an_unknown_id() {
        int unknownId = -1;
        assertThat(categories.with(unknownId), is(nullValue()));
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
