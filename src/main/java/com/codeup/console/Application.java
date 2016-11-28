/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.console;

import com.codeup.hibernate.repositories.CategoriesRepository;
import com.codeup.hibernate.Hibernate;
import com.codeup.hibernate.repositories.MoviesRepository;
import com.codeup.movies.Category;
import com.codeup.movies.Movie;
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
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        PrintStream output = System.out;
        MoviesConsole console = new MoviesConsole(
            output,
            new Console(input, output)
        );

        console.showMenu();
        int option = console.chooseOption();

        switch (option) {
            case MoviesConsole.ADD_MOVIE:
                String title = console.askForMovieTitle();
                int rating = console.askForMovieRating();
                String thumbnail = console.askForThumbnail();
                List<Category> movieCategories = console.chooseCategories(
                    categories.all()
                );
                Movie movie = Movie.publish(
                    title,
                    rating,
                    thumbnail,
                    movieCategories
                );
                movies.add(movie);
                break;
            default:
                output.println("Thank you!");
        }

        session.close();
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
