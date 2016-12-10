/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.application;

import com.codeup.console.Console;
import com.codeup.console.Menu;
import com.codeup.hibernate.repositories.CategoriesRepository;
import com.codeup.hibernate.Hibernate;
import com.codeup.hibernate.repositories.MoviesRepository;
import com.codeup.application.actions.AddCategoryAction;
import com.codeup.movies.catalog.*;
import com.codeup.application.actions.AddMovieAction;
import com.codeup.application.actions.SearchByCategoryAction;
import com.codeup.application.actions.SearchMovieByTitleAction;
import org.hibernate.Session;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Session session = Hibernate.openSession();
        CategoriesRepository categories = new CategoriesRepository(session);
        MoviesRepository movies = new MoviesRepository(session);
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        Console console = new Console(input, System.out);
        MoviesConsole moviesConsole = new MoviesConsole(console);
        AddMovieAction addMovie = new AddMovieAction(
            new AddMovie(movies),
            moviesConsole,
            categories
        );
        AddCategoryAction addCategory = new AddCategoryAction(
            new AddCategory(categories),
            new CategoriesConsole(console)
        );
        SearchMovieByTitleAction searchMovieByTitle = new SearchMovieByTitleAction(
            new SearchMovieByTitle(movies),
            moviesConsole
        );
        SearchByCategoryAction searchByCategory = new SearchByCategoryAction(
            new SearchByCategory(movies),
            moviesConsole,
            categories
        );

        Menu menu = new Menu(console);
        menu.addOption("Add a movie", addMovie);
        menu.addOption("Add a category", addCategory);
        menu.addOption("Search a movie by its title", searchMovieByTitle);
        menu.addOption("View movies by category", searchByCategory);
        menu.setExitMessage("Thank you!");
        menu.run();

        session.close();
        input.close();
        System.exit(0);
    }
}
