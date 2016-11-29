/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.console;

import com.codeup.hibernate.repositories.CategoriesRepository;
import com.codeup.hibernate.Hibernate;
import com.codeup.hibernate.repositories.MoviesRepository;
import com.codeup.movies.Category;
import com.codeup.movies.actions.AddMovieAction;
import org.hibernate.Session;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Session session = Hibernate.openSession();
        CategoriesRepository categories = new CategoriesRepository(session);
        MoviesRepository movies = new MoviesRepository(session);
        PrintStream output = System.out;
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        Console console = new Console(input, output);
        MoviesConsole moviesConsole = new MoviesConsole(console);
        AddMovieAction addMovie = new AddMovieAction(categories, movies, moviesConsole);

        Menu menu = new Menu(console);
        menu.addOption(new MenuOption("Add a movie", addMovie));
        menu.setExitOption(() -> output.println("Thank you!"));
        menu.render();
        menu.run();

        session.close();
        input.close();
    }

    private static void addCategory(CategoriesRepository categories, PrintStream output) {
        Category category = Category.named("action");
        categories.add(category);
        List<Category> all = categories.all();

        output.println(String.format(
            "%d: %s",
            category.id(),
            category.name()
        ));
        output.println(Arrays.toString(all.toArray()));
    }
}
