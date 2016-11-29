package com.codeup.console;

import com.codeup.movies.Category;

import java.util.ArrayList;
import java.util.List;

public class MoviesConsole {
    private final Console console;
    private ArrayList<Category> movieCategories = new ArrayList<>();

    MoviesConsole(Console console) {
        this.console = console;
    }

    public String askForMovieTitle() {
        return console.promptForNonEmptyText("Enter a title for the movie: ");
    }

    public int askForMovieRating() {
        return console.promptForNumberBetween(
            "Enter a rating for the movie (1-5): ",
            1,
            5
        );
    }

    public String askForThumbnail() {
        return console.promptForNonEmptyText(
            "Path to the thumbnail image for the movie: "
        );
    }

    public List<Category> chooseCategories(List<Category> availableCategories) {
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
