package com.mweems;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DefaultParserTest {

    @Test
    public void parseStringArrayOfCells() {
        //Arrange
        DefaultParser parser = new DefaultParser();

        //Act
        List<Cell> cells = parser.parseCellLocations("1,2 3,4");

        //Assert
        assertEquals(2, cells.size());
        assertEquals(1, cells.get(0).getXLoc());
        assertEquals(2, cells.get(0).getYLoc());
        assertEquals(3, cells.get(1).getXLoc());
        assertEquals(4, cells.get(1).getYLoc());

    }
}
