package com.mweems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class DefaultParserTest {

    DefaultParser parser = new DefaultParser();

    @Test
    public void parseStringArrayOfCells() {
        //Act
        List<Cell> cells = parser.parseCellLocations("1,2 3,4");

        //Assert
        assertEquals(2, cells.size());
        assertEquals(1, cells.get(0).getXLoc());
        assertEquals(2, cells.get(0).getYLoc());
        assertEquals(3, cells.get(1).getXLoc());
        assertEquals(4, cells.get(1).getYLoc());

    }

    @Test
    public void parseGridToString(){
        //Arrange
        List<Cell> cells = new ArrayList<Cell>();
        cells.add(new Cell(1,2));
        cells.add(new Cell(3,4));
        Grid mockGrid = mock(Grid.class);
        stub(mockGrid.getCells()).toReturn(cells);

        //Act
        String gridAsString = parser.parseGrid(mockGrid);

        //Assert
        assertEquals("1,2 3,4", gridAsString);
    }

}
