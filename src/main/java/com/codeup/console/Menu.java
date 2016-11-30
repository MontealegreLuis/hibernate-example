/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.console;

import com.codeup.validation.NumberWithinRange;

import java.util.LinkedHashMap;
import java.util.Map;

public class Menu {
    private final Console console;
    private int next = 0;
    private int exitOption;
    private Map<Integer, MenuOption> options = new LinkedHashMap<>();

    public Menu(Console console) {
        this.console = console;
    }

    public void addOption(String title, Action action) {
        options.put(next, new MenuOption(title, action));
        next++;
    }

    public void run() {
        int option;
        do {
            console.message(render());
            option = console.promptForNumber(
                "Choose an option (1-" + options.size() + "): ",
                new NumberWithinRange(1, options.size())
            );
            options.get(option - 1).execute();
        } while (option - 1 != exitOption);
    }

    private String render() {
        String menu = "";
        for (Map.Entry<Integer, MenuOption> pair : options.entrySet()) {
            menu += String.format("%d) %s\n", pair.getKey() + 1, pair.getValue());
        }
        return menu;
    }

    public void setExitMessage(String message) {
        exitOption = next;
        addOption(message, () -> console.message("Thank you!"));
    }
}
