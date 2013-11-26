package com.mweems;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DefaultCLITest {

    private DefaultCLI cli;

    @Before
    public void setup() {
        cli = new DefaultCLI();
    }

    @Test
    public void displayEmptyGridAsString() {
        //Arrange
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Judge judge = new DefaultJudge();
        Grid grid = new DefaultGrid(judge);

        //Act
        cli.displayOutPut(grid);

        //Assert
        assertEquals("No Living Cells", outContent.toString());
    }

    @Test
    public void acceptCellLocationInputFromUser() {
        //Arrange
        String expectedInput = setInput();

        //Act
        String userInput = cli.promptForCellLocations();

        //Assert
        assertEquals(expectedInput, userInput);
    }

    @Test
    public void acceptIterationInputFromUser() {
        //Arrange
        String expectedInput = setInput();

        //Act
        String userInput = cli.promptForNumIterations();

        //Assert
        assertEquals(expectedInput, userInput);
    }

    @Test
    public void displayGridWithTwoLiveCellsAsString(){
        //Arrange
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Judge judge = new DefaultJudge();
        Grid grid = new DefaultGrid(judge);
        List<Cell> cells = Arrays.asList(new Cell(1,2), new Cell(2,2), new Cell(3,2));
        grid.populate(cells);

        //Act
        cli.displayOutPut(grid);

        //Assert
        assertEquals("1,2 2,2 3,2", outContent.toString());

    }

    private String setInput() {
        String expectedUserInput = "user input";
        System.setIn(new ByteArrayInputStream(expectedUserInput.getBytes()));
        return expectedUserInput;
    }
}
