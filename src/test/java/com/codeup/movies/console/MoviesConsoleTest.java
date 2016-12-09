/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.movies.console;

import com.codeup.console.Console;
import com.codeup.movies.Category;
import com.codeup.movies.Movie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MoviesConsoleTest {
    @Test
    public void it_accepts_a_non_empty_title() {
        console = aConsoleWithInput(aTitle);

        assertThat(console.askForMovieTitle(), is(equalTo(aTitle)));
    }

    @Test
    public void it_keeps_prompting_until_a_valid_title_is_given() {
        console = aConsoleWithInput(anEmptyText, anEmptyText, aTitle);

        assertThat(console.askForMovieTitle(), is(equalTo(aTitle)));
    }

    @Test
    public void it_accepts_a_valid_range() {
        console = aConsoleWithInput(textRating);

        assertThat(console.askForMovieRating(), is(equalTo(numericRating)));
    }

    @Test
    public void it_keeps_prompting_until_a_valid_rating_is_given() {
        console = aConsoleWithInput(invalidRating, invalidRating, textRating);

        assertThat(console.askForMovieRating(), is(equalTo(numericRating)));
    }

    @Test
    public void it_accepts_a_non_empty_thumbnail() {
        console = aConsoleWithInput(thumbnail);

        assertThat(console.askForThumbnail(), is(equalTo(thumbnail)));
    }

    @Test
    public void it_keeps_prompting_until_a_valid_thumbnail_is_given() {
        console = aConsoleWithInput(anEmptyText, anEmptyText, thumbnail);

        assertThat(console.askForThumbnail(), is(equalTo(thumbnail)));
    }

    @Test
    public void it_accepts_choosing_a_single_category() {
        console = aConsoleWithInput(horrorOption, no);

        List<Category> selectedCategories = console.chooseCategories(categories);

        assertThat(selectedCategories.size(), is(equalTo(1)));
        assertThat(selectedCategories.get(0).name(), is(equalTo("horror")));
    }

    @Test
    public void it_accepts_choosing_several_categories() {
        console = aConsoleWithInput(horrorOption, yes, animatedOption, no);

        List<Category> selectedCategories = console.chooseCategories(categories);

        assertThat(selectedCategories.size(), is(equalTo(2)));
        assertThat(selectedCategories.get(0).name(), is(equalTo("horror")));
        assertThat(selectedCategories.get(1).name(), is(equalTo("animated")));
    }

    @Test
    public void it_accepts_a_valid_category() {
        console = aConsoleWithInput(actionOption);

        assertThat(console.chooseACategoryFrom(categories), is(equalTo(action)));
    }

    @Test
    public void it_keeps_prompting_until_a_valid_category_is_selected() {
        console = aConsoleWithInput(anEmptyText, anEmptyText, actionOption);

        assertThat(console.chooseACategoryFrom(categories), is(equalTo(action)));
    }

    @Test
    public void it_shows_several_movies() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        console = new MoviesConsole(new Console(
            null,
            new PrintStream(output)
        ));
        List<Movie> movies = Arrays.asList(
            Movie.publish("It", 4, "it.png", categories),
            Movie.publish("Home", 4, "home.png", categories),
            Movie.publish("The karate kid", 4, "karate.png", categories)
        );

        console.showMovies(movies);

        String moviesList = output.toString();
        assertThat(moviesList, containsString("It"));
        assertThat(moviesList, containsString("Home"));
        assertThat(moviesList, containsString("The karate kid"));
    }

    @Test
    public void it_shows_an_empty_list_of_movies() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        console = new MoviesConsole(new Console(
            null,
            new PrintStream(output)
        ));

        console.showMovies(Collections.emptyList());

        String moviesList = output.toString();
        assertThat(moviesList, containsString("0 results"));
    }

    private MoviesConsole aConsoleWithInput(String... userInput) {
        ByteArrayInputStream input = new ByteArrayInputStream(
            String.join("\n", userInput).getBytes()
        );
        return new MoviesConsole(new Console(
            new Scanner(input).useDelimiter("\n"),
            output
        ));
    }

    private MoviesConsole console;

    private final String anEmptyText = "   ";
    private final String aTitle = "A title";
    private final String textRating = "2";
    private final String invalidRating = "-3";
    private final int numericRating = 2;
    private final String thumbnail = "thumbnail.png";
    private final String actionOption = "1";
    private final String horrorOption = "2";
    private final String animatedOption = "3";
    private final String no = "n";
    private final String yes = "y";
    private final Category action = Category.named("action");
    private final List<Category> categories = Arrays.asList(
        action,
        Category.named("horror"),
        Category.named("animated")
    );

    @Mock
    private PrintStream output;
}
