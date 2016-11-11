/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.movies;

import java.io.Serializable;

public class Category implements Serializable {
    private long id;
    private String name;

    public Category() {}

    private Category(String name) {
        this.name = name;
    }

    public static Category named(String name) {
        return new Category(name);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
