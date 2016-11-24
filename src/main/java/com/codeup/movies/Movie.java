/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.movies;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private int id;
    private String title;
    private int rating;
    private String thumbnail;
    private List<Category> categories = new ArrayList<Category>();

    protected Movie() {}

    private Movie(
        String title,
        int rating,
        String thumbnail,
        List<Category> categories
    ) {
        this.title = title;
        this.rating = rating;
        this.thumbnail = thumbnail;
        this.categories = categories;
    }

    public static Movie publish(
        String title,
        int rating,
        String thumbnail,
        List<Category> categories
    ) {
        return new Movie(title, rating, thumbnail, categories);
    }

    public int id() {
        return id;
    }

    public String title() {
        return title;
    }

    public int rating() {
        return rating;
    }

    public String thumbnail() {
        return thumbnail;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
