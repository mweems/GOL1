package com.mweems;

import org.junit.Before;
import org.junit.Test;
import java.awt.*;
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
        stub(mockPrompter.promptForCellLocations()).toReturn("user input string");

        //Act
        cli.run();

        //Assert
        verify(mockStringParser).parse("user input string");
    }

    @Test
    public void populatesGridWithCells() {
        //Arrange
        ArrayList<Point> points = new ArrayList<Point>();
        points.add(new Point(1,2));

        stub(mockStringParser.parse(anyString())).toReturn(points);

        //Act
        cli.run();

        //Assert
        verify(mockGrid).populate(points);
    }
}
