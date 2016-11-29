/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.console;

import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Console {
    private final Scanner input;
    private final PrintStream output;

    Console(Scanner input, PrintStream output) {
        this.input = input;
        this.output = output;
    }

    String promptForNonEmptyText(String message) {
        output.print(message);
        String text = input.next();
        if (text.trim().isEmpty()) {
            output.println("Enter a non empty value");
            return promptForNonEmptyText(message);
        }
        return text;
    }

    int promptForNumberBetween(String message, int min, int max) {
        int number;
        output.print(message);
        try {
            number = input.nextInt();
            if (number < min || max < number) {
                output.printf(
                    "Enter a number between %d and %d",
                    min,
                    max
                );
                return promptForNumberBetween(message, min, max);
            }
        } catch (InputMismatchException e) {
            input.next();
            output.println("Enter a valid number");
            return promptForNumberBetween(message, min, max);
        }
        return number;
    }

    int chooseFromList(String message, List options) {
        output.println(message);
        for (int i = 0; i < options.size(); i++) {
            output.println((i + 1) + ") " + options.get(i));
        }
        return input.nextInt() - 1;
    }

    void askYesNoQuestion(String message, Action action) {
        do {
            action.execute();
            output.println(message);
        } while ("y".equalsIgnoreCase(input.next()));
    }

    public void message(String message) {
        output.println(message);
    }
}
