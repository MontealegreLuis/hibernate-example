package com.codeup.console;

import com.codeup.movies.Category;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MoviesConsole {
    public static final int ADD_MOVIE = 1;
    private final Scanner input;
    private final PrintStream output;

    MoviesConsole(Scanner input, PrintStream output) {
        this.input = input;
        this.output = output;
    }

    void showMenu() {
        output.println("Hibernate Movies Database HMDb");
        output.println("Choose an option");
        output.println("1) Add a movie");
        output.println("2) Exit");
    }

    int chooseOption() {
        output.print("Choose an option 1-2 ");
        return input.nextInt();
    }

    String askForMovieTitle() {
        output.print("Enter a title for the movie: ");
        return input.next();
    }

    int askForMovieRating() {
        output.print("\nEnter a rating for the movie (1-5): ");
        return input.nextInt();
    }

    String askForThumbnail() {
        output.print("Path to the thumbnail image for the movie: ");
        return input.next();
    }

    List<Category> chooseCategories(List<Category> availableCategories) {
        ArrayList<Category> movieCategories = new ArrayList<>();
        do {
            int selectedCategory = showCategories(availableCategories);
            movieCategories.add(availableCategories.get(selectedCategory));
            output.println("Do yu want to add another category? (y/n)");
        } while ("y".equalsIgnoreCase(input.next()));
        return movieCategories;
    }

    private int showCategories(List<Category> availableCategories) {
        output.println("Choose a category from the list");
        for (int i = 0; i < availableCategories.size(); i++) {
            Category category = availableCategories.get(i);
            output.println((i + 1) + ") " + category.name());
        }
        return input.nextInt() - 1;
    }
}
