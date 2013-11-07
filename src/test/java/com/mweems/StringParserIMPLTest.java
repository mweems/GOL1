package com.mweems;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SuppressWarnings("ALL")
public class StringParserIMPLTest {

    private StringToInt mockSTI;
    private StringParserIMPL stringParser;

    @Before
    public void setup() {
        mockSTI = mock(StringToInt.class);
        stringParser = new StringParserIMPL(mockSTI);

    }

    @Test
    public void convertStringToIntegers() {
        //Act
        stringParser.parseCellLocations("cell locations as string");

        //Assert
        verify(mockSTI).intValueOf("cell locations as string");
    }

    @Test
    public void convertIntegersToPoints() {
        //Arrange
        ArrayList<Integer> cellLocationsAsIntegers = new ArrayList<Integer>();
        cellLocationsAsIntegers.add(1);
        cellLocationsAsIntegers.add(2);
        stub(mockSTI.intValueOf(anyString())).toReturn(cellLocationsAsIntegers);

        //Act
        ArrayList<Point> cellLocationsAsPoints = stringParser.parseCellLocations("1,2");

        //Assert
        assertEquals(1, cellLocationsAsPoints.size());
        assertEquals(Point.class, cellLocationsAsPoints.get(0).getClass());
        assertEquals(1, cellLocationsAsPoints.get(0).getX(), 0);
        assertEquals(2, cellLocationsAsPoints.get(0).getY(), 0);
    }
}
