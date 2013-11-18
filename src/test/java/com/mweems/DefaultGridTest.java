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
    private Cell cell;

    @Before
    public void setup() {
        cells = new ArrayList<Cell>();
        mockJudge = mock(Judge.class);
        grid = new DefaultGrid(mockJudge);
        cell = new Cell(1,2);
    }

    @Test
    public void gridReturnsStringValueOfCellLocations() {
        //Arrange
        cells.add(new Cell(1,2));
        cells.add(new Cell(3, 4));
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
        stub(mockJudge.isAlive(cells, grid, cell)).toReturn(false);

        //Act
        grid.populate(grid.tick(1));

        //Assert
        assertEquals(expected, grid.getCells());
    }

    @Test
    public void gridHasNewLiveCellAddedAfterOneTick() {
        //Arrange
        DefaultJudge judge = new DefaultJudge();
        DefaultGrid grid1 = new DefaultGrid(judge);
        List<Cell> expected = new ArrayList<Cell>();
        expected.add(new Cell(1,1));
        expected.add(new Cell(1,2));
        expected.add(new Cell(2,1));
        expected.add(new Cell(2,2));

        cells.add(new Cell(1,1));
        cells.add(new Cell(2,1));
        cells.add(new Cell(2,2));
        grid1.populate(cells);

        //Act
        grid1.populate(grid1.tick(1));

        //Assert
        assertEquals(expected, grid1.getCells());

    }
}
