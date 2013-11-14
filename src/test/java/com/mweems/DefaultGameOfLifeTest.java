package com.mweems;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class DefaultGameOfLifeTest {

    private CLI mockCLI;
    private Parser mockParser;
    private Grid mockGrid;
    private DefaultGameOfLife defaultGameOfLife;
    private Cell mockCell;

    @Before
    public void setup() {
        mockCLI = mock(CLI.class);
        mockParser = mock(Parser.class);
        mockGrid = mock(Grid.class);
        defaultGameOfLife = new DefaultGameOfLife(mockCLI, mockParser, mockGrid);
        mockCell = mock(Cell.class);
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
        ArrayList<Cell> cells = new ArrayList<Cell>();
        cells.add(mockCell);

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
    public void parseNumIterationsString() {
        //Arrange
        stub(mockCLI.promptForNumIterations()).toReturn("num iterations");

        //Act
        defaultGameOfLife.getIterations();

        //Assert
        verify(mockParser).parseNumIterations("num iterations");
    }

    @Test
    public void completeOneTick() {
        //Arrange
        stub(mockParser.parseNumIterations(anyString())).toReturn(1);

        //Act
        defaultGameOfLife.run();

        //Assert
        verify(mockGrid).tick(1);
    }
}