/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.console;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MenuOptionTest {
    @Test
    public void it_executes_its_associated_action() {
        option.execute();

        verify(action).execute();
    }

    @Test
    public void it_uses_its_title_when_it_is_converted_to_string() {
        assertThat(option.toString(), is(title));
    }

    private MenuOption option;

    private String title = "title";

    @Mock
    private Action action;

    @Before
    public void createMenuOption() {
        option =  new MenuOption(title, action);
    }
}
