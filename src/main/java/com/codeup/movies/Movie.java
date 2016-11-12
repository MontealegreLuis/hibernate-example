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

    public Movie() {}

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
