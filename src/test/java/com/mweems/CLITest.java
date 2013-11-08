package com.mweems;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class CLITest {

    private UserInteractions mockUserInteractions;
    private Parser mockParser;
    private Grid mockGrid;
    private CLI cli;

    @Before
    public void setup() {
        mockUserInteractions = mock(UserInteractions.class);
        mockParser = mock(Parser.class);
        mockGrid = mock(Grid.class);
        cli = new CLI(mockUserInteractions, mockParser, mockGrid);
    }

    @Test
    public void promptsForCellInitializationString() {
        //Act
        cli.run();

        //Assert
        verify(mockUserInteractions).promptForCellLocations();
    }

    @Test
    public void parsesCellInitializationString() {
        //Arrange
        stub(mockUserInteractions.promptForCellLocations()).toReturn("user input cell locations");

        //Act
        cli.run();

        //Assert
        verify(mockParser).parseCellLocations("user input cell locations");
    }

    @Test
    public void populatesGridWithCells() {
        //Arrange
        ArrayList<Cell> cells = new ArrayList<Cell>();
        cells.add(new Cell(1, 2));

        stub(mockParser.parseCellLocations(anyString())).toReturn(cells);

        //Act
        cli.run();

        //Assert
        verify(mockGrid).populate(cells);
    }

    @Test
    public void parsesGridToString() {
        //Act
        cli.run();

        //Assert
        verify(mockParser).parseGrid(mockGrid);
    }

    @Test
    public void passStringToUserInteractionsForDisplayToUser() {
        //Arrange
        stub(mockParser.parseGrid(mockGrid)).toReturn("grid as string");

        //Act
        cli.run();

        //Assert
        verify(mockUserInteractions).displayOutPut("grid as string");
    }

}