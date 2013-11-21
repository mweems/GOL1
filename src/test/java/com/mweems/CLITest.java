package com.mweems;

import org.junit.Before;
import org.junit.Test;
import java.awt.*;
import java.util.ArrayList;
import static org.mockito.Mockito.*;

public class CLITest {

    private UserInteraction mockUserInteraction;
    private Parser mockParser;
    private Grid mockGrid;
    private CLI cli;

    @Before
    public void setup() {
        mockUserInteraction = mock(UserInteraction.class);
        mockParser = mock(Parser.class);
        mockGrid = mock(Grid.class);
        cli = new CLI(mockUserInteraction, mockParser, mockGrid);
    }

    @Test
    public void promptsForCellInitializationString() {
        //Act
        cli.run();

        //Assert
        verify(mockUserInteraction).promptForCellLocations();
    }

    @Test
    public void parsesCellInitializationString() {
        //Arrange
        stub(mockUserInteraction.promptForCellLocations()).toReturn("user input string");

        //Act
        cli.run();

        //Assert
        verify(mockParser).parseString("user input string");
    }

    @Test
    public void populatesGridWithCells() {
        //Arrange
        ArrayList<Point> points = new ArrayList<Point>();
        points.add(new Point(1,2));

        stub(mockParser.parseString(anyString())).toReturn(points);

        //Act
        cli.run();

        //Assert
        verify(mockGrid).populate(points);
    }

    @Test
    public void parseGridToString() {
        //Act
        cli.run();

        //Assert
        verify(mockParser).parseGrid(mockGrid);
    }

    @Test
    public void passStringOfCellLocationsToUserInteractions() {
        //Arrange
        ArrayList<Point> points = new ArrayList<Point>();
        points.add(new Point(1,2));
        stub(mockGrid.populate(ArrayList<Point>)

        //Act
        cli.run();

        //Assert
        verify(mockUserInteraction).displayOutput("grid as string");

    }
}
