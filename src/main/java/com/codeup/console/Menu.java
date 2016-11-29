/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.console;

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

    public void addOption(MenuOption option) {
        options.put(next, option);
        next++;
    }

    public void render() {
        console.message(toString());
    }

    @Override
    public String toString() {
        String menu = "";
        for (Map.Entry<Integer, MenuOption> pair : options.entrySet()) {
            menu += String.format("%d) %s\n", pair.getKey() + 1, pair.getValue());
        }
        return menu;
    }

    public void run() {
        int option;
        do {
            option = console.promptForNumberBetween(
                "Choose an option (1-" + options.size() + "): ",
                1,
                options.size()
            );
            options.get(option - 1).execute();
        } while (option - 1 != exitOption);
    }

    public void setExitOption(Action action) {
        exitOption = next;
        addOption(new MenuOption("Exit", action));
    }
}
