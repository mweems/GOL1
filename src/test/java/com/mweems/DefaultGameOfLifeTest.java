package com.mweems;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class DefaultGameOfLifeTest {

    private CLI mockCLI;
    private Parser mockParser;
    private Grid mockGrid;
    private Cell mockCell;
    private DefaultGameOfLife defaultGameOfLife;

    @Before
    public void setup() {
        mockCLI = mock(CLI.class);
        mockParser = mock(Parser.class);
        mockGrid = mock(Grid.class);
        mockCell = mock(Cell.class);
        defaultGameOfLife = new DefaultGameOfLife(mockCLI, mockParser, mockGrid);
    }

    @Test
    public void promptsForCellInitializationString() {
        //Act
        defaultGameOfLife.getCells();

        //Assert
        verify(mockCLI).promptForCellLocations();
    }

    @Test
    public void parsesCellInitializationString() {
        //Arrange
        stub(mockCLI.promptForCellLocations()).toReturn("user input cell locations");

        //Act
        defaultGameOfLife.getCells();

        //Assert
        verify(mockParser).parseCellLocations("user input cell locations");
    }

    @Test
    public void populatesGridWithCells() {
        //Arrange
        List<Cell> cells = Arrays.asList(mockCell);

        stub(mockParser.parseCellLocations(anyString())).toReturn(cells);

        //Act
        defaultGameOfLife.run();

        //Assert
        verify(mockGrid).populate(cells);
    }

    @Test
    public void passStringToUserInteractionsForDisplayToUser() {
        //Arrange
        stub(mockGrid.toString()).toReturn("grid as string");

        //Act
        defaultGameOfLife.displayOutput("grid as string");

        //Assert
        verify(mockCLI).displayOutPut("grid as string");
    }

    @Test
    public void promptUserForNumberOfIterations() {
        //Act
        defaultGameOfLife.getIterations();

        //Assert
        verify(mockCLI).promptForNumIterations();
    }

    @Test
    public void parseNumberOfIterationsToString() {
        //Arrange
        stub(mockCLI.promptForNumIterations()).toReturn("num iterations");

        //Act
        defaultGameOfLife.getIterations();

        //Assert
        verify(mockParser).parseNumIterations("num iterations");
    }

    @Test
    public void callTickWithCorrectNumberOfIterations() {
        //Arrange
        stub(mockParser.parseNumIterations(anyString())).toReturn(1);

        //Act
        defaultGameOfLife.run();

        //Assert
        verify(mockGrid).tick(1);
    }
}