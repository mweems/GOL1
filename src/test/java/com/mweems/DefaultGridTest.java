package com.mweems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DefaultGridTest {

    @Test
    public void gridReturnsStringValueOfCellLocations() {
        //Arrange
        DefaultGrid grid = new DefaultGrid();
        List<Cell> cells = new ArrayList<Cell>();
        cells.add(new Cell(1,2));
        cells.add(new Cell(3,4));
        grid.populate(cells);

        //Act
        String gridAsString = grid.toString();

        //Assert
        assertEquals("1,2 3,4", gridAsString);
    }
}
