package com.mweems;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SuppressWarnings("ALL")
public class StringParserIMPLTest {

    private ToInt mockToInt;
    private StringParserIMPL stringParser;

    @Before
    public void setup() {
        mockToInt = mock(ToInt.class);
        stringParser = new StringParserIMPL(mockToInt);

    }

    @Test
    public void convertStringToIntegers() {
        //Act
        stringParser.parseCellLocations("cell locations as string");

        //Assert
        verify(mockToInt).intValueOfString("cell locations as string");
    }

    @Test
    public void convertIntegersToPoints() {
        //Arrange
        ArrayList<Integer> cellLocationsAsIntegers = new ArrayList<Integer>();
        cellLocationsAsIntegers.add(1);
        cellLocationsAsIntegers.add(2);
        stub(mockToInt.intValueOfString(anyString())).toReturn(cellLocationsAsIntegers);

        //Act
        ArrayList<Point> cellLocationsAsPoints = stringParser.parseCellLocations("1,2");

        //Assert
        assertEquals(1, cellLocationsAsPoints.size());
        assertEquals(Point.class, cellLocationsAsPoints.get(0).getClass());
        assertEquals(1, cellLocationsAsPoints.get(0).getX(), 0);
        assertEquals(2, cellLocationsAsPoints.get(0).getY(), 0);
    }

    @Test
    public void convertIterationStringIntoInteger() {
        //Arrange
        ArrayList<Integer> cellLocationsAsIntegers = new ArrayList<Integer>();
        cellLocationsAsIntegers.add(1);
        stub(mockToInt.intValueOfString(anyString())).toReturn(cellLocationsAsIntegers);

        //Act
        int numIterations = stringParser.parseIterations("1");

        //Assert
        assertEquals(1,numIterations);
    }

    @Test
    public void convertGridCallsToInt() {
        //Arrange
        Grid mockGrid = mock(Grid.class);

        //Act
        stringParser.parseGrid(mockGrid);

        //Assert
        verify(mockToInt).intValueOfGrid(mockGrid);

    }

    @Test
    public void convertGridObjectIntoString() {
        //Arrange
        Grid mockGrid = mock(Grid.class);
        ArrayList<Integer> cellLocationsAsIntegers = new ArrayList<Integer>();
        cellLocationsAsIntegers.add(1);
        cellLocationsAsIntegers.add(2);
        stub(mockToInt.intValueOfGrid(Matchers.<Grid>any())).toReturn(cellLocationsAsIntegers);

        //Act
        String cellLocationsAsString = stringParser.parseGrid(mockGrid);

        //Assert
        assertEquals(2,cellLocationsAsString.length());
    }
}
