/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.console;

import com.codeup.validation.IntegerFromString;
import com.codeup.validation.NumberWithinRange;
import com.codeup.validation.Validator;

import java.io.PrintStream;
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

    public int promptForInteger(String message, Validator<String> validator) {
        output.print(message);
        String possiblyANumber = input.next();
        if (!validator.isValid(possiblyANumber)) {
            output.println(validator.errorMessage());
            return promptForInteger(message, validator);
        }
        return Integer.parseInt(possiblyANumber);
    }

    public int chooseFromList(String message, List options) {
        output.println(buildOptionsList(options));
        int chosenNumber = promptForInteger(
            message,
            new IntegerFromString(new NumberWithinRange(1, options.size()))
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
