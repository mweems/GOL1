package com.mweems;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DefaultJudgeTest {

    private Cell testCell;
    private DefaultJudge judge;
    private Grid grid;
    private List<Cell> neighbors;

    @Before
    public void setup() {
        testCell = new Cell(1,2);
        judge = new DefaultJudge();
        grid = new DefaultGrid(judge);
        neighbors = new ArrayList<Cell>();
        neighbors.add(new Cell(0,1));
        neighbors.add(new Cell(0,2));
        neighbors.add(new Cell(0,3));
        neighbors.add(new Cell(1,1));
        neighbors.add(new Cell(1,3));
        neighbors.add(new Cell(2,1));
        neighbors.add(new Cell(2,2));
        neighbors.add(new Cell(2,3));
    }

    @Test
    public void isAliveReturnsFalseWhenCellHasLessThanTwoNeighbors() {
        //Arrange
        List<Cell> cells = Arrays.asList(testCell);
        grid.populate(cells);

        //Act
        Boolean isAlive = judge.isAlive(testCell, neighbors, grid);

        //Assert
        assertFalse(isAlive);
    }

    @Test
    public void isAliveReturnsTrueWhenCellHasTwoOrMoreNeighbors() {
        //Arrange
        List<Cell> cells = Arrays.asList(testCell, new Cell(2,2), new Cell(1,1));
        grid.populate(cells);

        //Act
        Boolean isAlive = judge.isAlive(testCell, neighbors, grid);

        //Assert
        assertTrue(isAlive);
    }

    @Test
    public void isAliveReturnsFalseWhenCellHasMoreThanThreeNeighbors() {
        //Arrange
        List<Cell> cells = Arrays.asList(new Cell(0,1), new Cell(2,2), new Cell(1,1), new Cell(2,1));
        grid.populate(cells);

        //Act
        Boolean isAlive = judge.isAlive(testCell, neighbors, grid);

        //Assert
        assertFalse(isAlive);
    }

    @Test
    public void DeadCellStaysDeadWhenSurroundedByTwoOrLessLiveNeighbors() {
        //Arrange
        List<Cell> cells = Arrays.asList(new Cell(2,2), new Cell(1,1));
        testCell.setAlive(false);
        grid.populate(cells);

        //Act
        Boolean isAlive = judge.isAlive(testCell, neighbors, grid);

        //Assert
        assertFalse(isAlive);
    }
}
