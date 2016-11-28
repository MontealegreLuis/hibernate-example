package com.codeup.console;

import com.codeup.movies.Category;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

class MoviesConsole {
    static final int ADD_MOVIE = 1;
    private final PrintStream output;
    private final Console console;
    private ArrayList<Category> movieCategories = new ArrayList<>();

    MoviesConsole(PrintStream output, Console console) {
        this.output = output;
        this.console = console;
    }

    void showMenu() {
        output.println("Hibernate Movies Database HMDb");
        output.println("Choose an option");
        output.println("1) Add a movie");
        output.println("2) Exit");
    }

    int chooseOption() {
        return console.promptForNumberBetween(
            "Choose an option (1-2): ",
            1,
            2
        );
    }

    String askForMovieTitle() {
        return console.promptForNonEmptyText("Enter a title for the movie: ");
    }

    int askForMovieRating() {
        return console.promptForNumberBetween(
            "\nEnter a rating for the movie (1-5): ",
            1,
            5
        );
    }

    String askForThumbnail() {
        return console.promptForNonEmptyText(
            "Path to the thumbnail image for the movie: "
        );
    }

    List<Category> chooseCategories(List<Category> availableCategories) {
        console.askYesNoQuestion(
            "Do you want to add another category? (y/n)",
            () -> addMovieCategory(availableCategories)
        );
        return movieCategories;
    }

    private void addMovieCategory(List<Category> availableCategories) {
        int selectedCategory = console.chooseFromList(
            "Choose a category: ",
            availableCategories
        );
        movieCategories.add(availableCategories.get(selectedCategory));
    }
}
