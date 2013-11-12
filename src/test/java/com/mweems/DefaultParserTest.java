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
        assertEquals(1, cells.get(0).getX());
        assertEquals(2, cells.get(0).getY());
        assertEquals(3, cells.get(1).getX());
        assertEquals(4, cells.get(1).getY());

    }
}
