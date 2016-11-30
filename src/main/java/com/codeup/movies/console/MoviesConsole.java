package com.codeup.movies.console;

import com.codeup.console.Console;
import com.codeup.movies.Category;
import com.codeup.movies.Movie;
import com.codeup.validation.NumberWithinRange;

import java.util.ArrayList;
import java.util.List;

public class MoviesConsole {
    private final Console console;
    private ArrayList<Category> movieCategories = new ArrayList<>();

    public MoviesConsole(Console console) {
        this.console = console;
    }

    public String askForMovieTitle() {
        return console.promptForNonEmptyText("Enter a title for the movie: ");
    }

    public int askForMovieRating() {
        return console.promptForNumber(
            "Enter a rating for the movie (1-5): ",
            new NumberWithinRange(1, 5)
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

    public Category chooseACategoryFrom(List<Category> availableCategories) {
        int selectedCategory = console.chooseFromList(
            "Choose a category: ",
            availableCategories
        );
        return availableCategories.get(selectedCategory);
    }

    private void addMovieCategory(List<Category> availableCategories) {
        int selectedCategory = console.chooseFromList(
            "Choose a category: ",
            availableCategories
        );
        movieCategories.add(availableCategories.get(selectedCategory));
    }

    public void showMovies(List<Movie> movies) {
        String moviesTable = String.format("%d results found.%n", movies.size());
        for (Movie movie : movies) {
            moviesTable += String.format(
                "%s, rated with %d stars.%n",
                movie.title(),
                movie.rating()
            );
        }
        console.message(moviesTable);
    }
}
