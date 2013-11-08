package com.mweems;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DefaultParserTest {

    @Test
    public void parseStringArrayOfCells() {
        //Arrange
        DefaultParser parser = new DefaultParser();

        //Act
        ArrayList<Cell> cells = parser.parseCellLocations("1,2 3,4 5,6");

        //Assert
        assertEquals(3, cells.size());
        assertEquals(1, cells.get(0).getXLoc());
        assertEquals(2, cells.get(0).getYLoc());
        assertEquals(6, cells.get(2).getYLoc());

    }
}
