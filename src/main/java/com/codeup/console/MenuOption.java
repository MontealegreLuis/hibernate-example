/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.console;

public class MenuOption {
    private String title;
    private Action action;

    MenuOption(String title, Action action) {
        this.title = title;
        this.action = action;
    }

    public void execute() {
        action.execute();
    }

    @Override
    public String toString() {
        return title;
    }
}
