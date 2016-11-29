/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.movies;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {
    private int id;
    private String name;
    private List<Movie> movies;

    protected Category() {}

    private Category(String name) {
        this.name = name;
    }

    public static Category named(String name) {
        return new Category(name);
    }

    public int id() {
        return id;
    }

    public String name() {
        return name;
    }

    private List<Movie> getMovies() {
        return movies;
    }

    private void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    @Override
    public String toString() {
        return name;
    }
}
