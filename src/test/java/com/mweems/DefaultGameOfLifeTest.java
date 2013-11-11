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
        defaultGameOfLife.run();

        //Assert
        verify(mockCLI).promptForCellLocations();
    }

    @Test
    public void parsesCellInitializationString() {
        //Arrange
        stub(mockCLI.promptForCellLocations()).toReturn("user input cell locations");

        //Act
        defaultGameOfLife.run();

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
    public void parsesGridToString() {
        //Act
        defaultGameOfLife.run();

        //Assert
        verify(mockParser).parseGrid(mockGrid);
    }

    @Test
    public void passStringToUserInteractionsForDisplayToUser() {
        //Arrange
        stub(mockParser.parseGrid(mockGrid)).toReturn("grid as string");

        //Act
        defaultGameOfLife.run();

        //Assert
        verify(mockCLI).displayOutPut("grid as string");
    }

}