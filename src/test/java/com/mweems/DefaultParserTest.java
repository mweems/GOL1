package com.mweems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DefaultParserTest {

    DefaultParser parser = new DefaultParser();

    @Test
    public void parseStringArrayOfCells() {
        //Act
        List<Cell> cells = parser.parseCellLocations("1,2 3,4 5,6");

        //Assert
        assertEquals(3, cells.size());
        assertEquals(1, cells.get(0).getXLoc());
        assertEquals(2, cells.get(0).getYLoc());
        assertEquals(6, cells.get(2).getYLoc());

    }

    @Test
    public void parseGridToString(){
        //Arrange
        List<Cell> cells = new ArrayList<Cell>();
        cells.add(new Cell(1,2));
        Grid grid = new DefaultGrid();

        //Act
        grid.populate(cells);
        String gridAsString = parser.parseGrid(grid);

        //Assert
        assertEquals("1,2", gridAsString);
    }

}
