package com.mweems;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;

public class DefaultGridTest {

    private DefaultGrid grid;
    private List<Cell> cells;
    private Judge mockJudge;

    @Before
    public void setup() {
        cells = new ArrayList<Cell>();
        mockJudge = mock(Judge.class);
        grid = new DefaultGrid(mockJudge);
    }

    @Test
    public void gridReturnsStringValueOfCellLocations() {
        //Arrange
        cells.add(new Cell(1,2));
        cells.add(new Cell(3,4));
        grid.populate(cells);

        //Act
        String gridAsString = grid.toString();

        //Assert
        assertEquals("1,2 3,4", gridAsString);
    }

    @Test
    public void gridHasNoCellsAfterOneTickWhenStartingWithOneCell() {
        //Arrange
        cells.add(new Cell(1,2));
        grid.populate(cells);
        List<Cell> expected = new ArrayList<Cell>();
        stub(mockJudge.isAlive(cells, grid)).toReturn(false);

        //Act
        grid.populate(grid.tick(1));

        //Assert
        assertEquals(expected, grid.getCells());
    }
}
