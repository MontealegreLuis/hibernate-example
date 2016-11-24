/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.movies;

import java.io.Serializable;

public class Category implements Serializable {
    private long id;
    private String name;

    protected Category() {}

    private Category(String name) {
        this.name = name;
    }

    public static Category named(String name) {
        return new Category(name);
    }

    public long id() {
        return id;
    }

    public String name() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
