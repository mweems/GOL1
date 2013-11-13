package com.mweems;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class DefaultCLITest {

    @Test
    public void displayGridAsString() {
        //Arrange
        DefaultCLI cli = new DefaultCLI();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        //Act
        cli.displayOutPut("grid as string");

        //Assert
        assertEquals("grid as string", outContent.toString());
    }

    @Test
    public void acceptCellLocationInputFromUser() {
        //Arrange
        DefaultCLI CLI = new DefaultCLI();

        String expectedUserInput = "user input";
        System.setIn(new ByteArrayInputStream(expectedUserInput.getBytes()));

        //Act
        String userInput = CLI.promptForCellLocations();

        //Assert
        assertEquals(expectedUserInput, userInput);
    }
}
