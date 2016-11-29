/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup;

import com.codeup.console.Console;
import com.codeup.console.Menu;
import com.codeup.hibernate.repositories.CategoriesRepository;
import com.codeup.hibernate.Hibernate;
import com.codeup.hibernate.repositories.MoviesRepository;
import com.codeup.movies.Category;
import com.codeup.movies.actions.AddCategoryAction;
import com.codeup.movies.actions.AddMovieAction;
import com.codeup.movies.actions.CategoriesConsole;
import com.codeup.movies.actions.MoviesConsole;
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
        AddMovieAction addMovie = new AddMovieAction(
            categories,
            movies,
            new MoviesConsole(console)
        );
        AddCategoryAction addCategory = new AddCategoryAction(
            categories,
            new CategoriesConsole(console)
        );

        Menu menu = new Menu(console);
        menu.addOption("Add a movie", addMovie);
        menu.addOption("Add a category", addCategory);
        menu.setExitOption(() -> output.println("Thank you!"));
        menu.run();

        session.close();
        input.close();
    }

    private static void showCategories(CategoriesRepository categories, PrintStream output) {
        List<Category> all = categories.all();
        output.println(Arrays.toString(all.toArray()));
    }
}
