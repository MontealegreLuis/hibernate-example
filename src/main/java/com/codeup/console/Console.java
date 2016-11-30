/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.console;

import com.codeup.validation.NumberWithinRange;
import com.codeup.validation.Validator;

import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Console {
    private final Scanner input;
    private final PrintStream output;

    public Console(Scanner input, PrintStream output) {
        this.input = input;
        this.output = output;
    }

    public String promptForNonEmptyText(String message) {
        output.print(message);
        String text = input.next();
        if (text.trim().isEmpty()) {
            output.println("Enter a non empty value");
            return promptForNonEmptyText(message);
        }
        return text;
    }

    public int promptForNumber(String message, Validator<Integer> validator) {
        int number;
        output.print(message);
        try {
            number = input.nextInt();
            if (!validator.isValid(number)) {
                output.println(validator.errorMessage());
                return promptForNumber(message, validator);
            }
        } catch (InputMismatchException e) {
            input.next();
            output.println("Enter a valid number");
            return promptForNumber(message, validator);
        }
        return number;
    }

    public int chooseFromList(String message, List options) {
        output.println(buildOptionsList(options));
        int chosenNumber = promptForNumber(
            message,
            new NumberWithinRange(1, options.size())
        );
        return chosenNumber - 1;
    }

    private String buildOptionsList(List options) {
        String list = "";
        for (int i = 0; i < options.size(); i++) {
            list += String.format("%n%d) %s", i + 1, options.get(i));
        }
        return list;
    }

    public void askYesNoQuestion(String message, Action action) {
        do {
            action.execute();
            output.println(message);
        } while ("y".equalsIgnoreCase(input.next()));
    }

    public void message(String message) {
        output.println(message);
    }
}
