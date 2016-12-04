/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.console;

import com.codeup.validation.Validator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MenuTest {
    @Test
    public void it_executes_a_single_action() {
        when(console.promptForInteger(any(String.class), any(Validator.class)))
            .thenReturn(secondOption, exitOption);
        ;

        menu.run();

        verify(action2).execute();
    }

    @Test
    public void it_executes_all_the_actions() {
        when(console.promptForInteger(any(String.class), any(Validator.class)))
            .thenReturn(firstOption, secondOption, thirdOption, exitOption);
        ;

        menu.run();

        verify(action1).execute();
        verify(action2).execute();
        verify(action3).execute();
    }

    @Test
    public void it_executes_no_action() {
        when(console.promptForInteger(any(String.class), any(Validator.class)))
            .thenReturn(exitOption);
        ;

        menu.run();

        verify(action1, never()).execute();
        verify(action2, never()).execute();
        verify(action3, never()).execute();
    }

    @Before
    public void createMenu() {
        menu = new Menu(console);
        menu.addOption(null, action1);
        menu.addOption(null, action2);
        menu.addOption(null, action3);
        menu.setExitMessage("Thanks!");
    }

    private Menu menu;

    @Mock
    private Console console;
    @Mock
    private Action action1;
    @Mock
    private Action action2;
    @Mock
    private Action action3;

    private int firstOption = 1;
    private int secondOption = 2;
    private int thirdOption = 3;
    private int exitOption = 4;
}
