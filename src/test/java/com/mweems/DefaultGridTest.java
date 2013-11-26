package com.mweems;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;

public class DefaultGridTest {

    private Judge mockJudge;

    @Before
    public void setup() {
        mockJudge = mock(Judge.class);
    }

    @Test
    public void gridReturnsStringValueOfCellLocations() {
        //Arrange
        DefaultGrid grid = new DefaultGrid(mockJudge);
        List<Cell> cells = Arrays.asList(new Cell(1,2), new Cell(3,4));
        grid.populate(cells);

        //Act
        String gridAsString = grid.toString();

        //Assert
        assertEquals("1,2 3,4", gridAsString);
    }

    @Test
    public void gridHasNoCellsAfterOneTickWhenStartingWithOneCell() {
        //Arrange
        Cell testCell = new Cell(1,2);
        DefaultGrid grid = new DefaultGrid(mockJudge);
        grid.populate(Arrays.asList(testCell));
        stub(mockJudge.isAlive(testCell, Arrays.asList(testCell), grid)).toReturn(false);

        //Act
        grid.tick(1);

        //Assert
        assertFalse(grid.contains(testCell));
    }

    @Test
    public void gridHasNewLiveCellAddedAfterOneTick() {
        //Arrange
        Cell newLiveCell = new Cell(1,2);
        DefaultJudge judge = new DefaultJudge();
        DefaultGrid grid = new DefaultGrid(judge);
        List<Cell> cells = Arrays.asList(new Cell(1,1), new Cell(2,1), new Cell(2,2));
        grid.populate(cells);

        //Act
        grid.tick(1);

        //Assert
        assertTrue(grid.contains(newLiveCell));


    }
}
