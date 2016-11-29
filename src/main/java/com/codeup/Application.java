/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup;

import com.codeup.console.Console;
import com.codeup.console.Menu;
import com.codeup.hibernate.repositories.CategoriesRepository;
import com.codeup.hibernate.Hibernate;
import com.codeup.hibernate.repositories.MoviesRepository;
import com.codeup.movies.actions.*;
import org.hibernate.Session;

import java.io.PrintStream;
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
        AddMovie addMovie = new AddMovie(
            categories,
            movies,
            moviesConsole
        );
        AddCategory addCategory = new AddCategory(
            categories,
            new CategoriesConsole(console)
        );
        SearchMovieByTitle searchMovieByTitle = new SearchMovieByTitle(
            movies,
            moviesConsole
        );
        Menu menu = new Menu(console);
        menu.addOption("Add a movie", addMovie);
        menu.addOption("Add a category", addCategory);
        menu.addOption("Search a movie by its title", searchMovieByTitle);
        menu.setExitOption(() -> output.println("Thank you!"));
        menu.run();

        session.close();
        input.close();
    }
}
