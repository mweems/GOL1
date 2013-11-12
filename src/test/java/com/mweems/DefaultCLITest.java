package com.mweems;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class DefaultCLITest {

    @Test
    public void displayGridAsString() {
        //Arrange
        DefaultCLI CLI = new DefaultCLI();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        //Act
        CLI.displayOutPut("grid as string");

        //Assert
        assertEquals("grid as string", outContent.toString());
    }

    @Test
    public void acceptInputFromUser() {
        //Arrange
        DefaultCLI CLI = new DefaultCLI();

        String data = "user input";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        //Act
        String userInput = CLI.promptForCellLocations();

        //Assert
        assertEquals(data, userInput);
    }
}
