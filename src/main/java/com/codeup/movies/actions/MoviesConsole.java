package com.codeup.movies.actions;

import com.codeup.console.Console;
import com.codeup.movies.Category;

import java.util.ArrayList;
import java.util.List;

public class MoviesConsole {
    private final Console console;
    private ArrayList<Category> movieCategories = new ArrayList<>();

    public MoviesConsole(Console console) {
        this.console = console;
    }

    String askForMovieTitle() {
        return console.promptForNonEmptyText("Enter a title for the movie: ");
    }

    int askForMovieRating() {
        return console.promptForNumberBetween(
            "Enter a rating for the movie (1-5): ",
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
