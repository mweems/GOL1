package com.mweems;


import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;

public class CLITest {

    @Test
    public void promptsForCellInitializationString() {
        //Arrange
        Prompter mockPrompter = mock(Prompter.class);
        StringParser mockStringParser = mock(StringParser.class);

        //Act
        CLI cli = new CLI(mockPrompter, mockStringParser);
        cli.run();

        //Assert
        verify(mockPrompter).promptForCellLocations();

    }

    @Test
    public void parsesCellInitializationString() {
        //Arrange
        Prompter mockPrompter = mock(Prompter.class);
        stub(mockPrompter.promptForCellLocations()).toReturn("user input string");
        StringParser mockStringParser = mock(StringParser.class);

        //Act
        CLI cli = new CLI(mockPrompter, mockStringParser);
        cli.run();

        //Assert
        verify(mockStringParser).parse("user input string");
    }
}
