package com.mweems;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class CLITest {

    private Prompter mockPrompter;
    private StringParser mockStringParser;
    private Grid mockGrid;
    private CLI cli;

    @Before
    public void setup() {
        mockPrompter = mock(Prompter.class);
        mockStringParser = mock(StringParser.class);
        mockGrid = mock(Grid.class);
        cli = new CLI(mockPrompter, mockStringParser, mockGrid);
    }

    @Test
    public void promptsForCellInitializationString() {
        //Act
        cli.run();

        //Assert
        verify(mockPrompter).promptForCellLocations();
    }

    @Test
    public void parsesCellInitializationString() {
        //Arrange
        stub(mockPrompter.promptForCellLocations()).toReturn("user input cell locations");

        //Act
        cli.run();

        //Assert
        verify(mockStringParser).parseCellLocations("user input cell locations");
    }

    @Test
    public void populatesGridWithCells() {
        //Arrange
        ArrayList<Cell> cells = new ArrayList<Cell>();
        cells.add(new Cell(1, 2));

        stub(mockStringParser.parseCellLocations(anyString())).toReturn(cells);

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
        verify(mockStringParser).parseGrid(mockGrid);
    }

}