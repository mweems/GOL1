package com.mweems;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DefaultJudgeTest {

    private DefaultJudge judge;
    private Grid grid;
    private List<Cell> cells;
    private List<Cell> neighbors;
    private Cell cell;

    @Before
    public void setup() {
        judge = new DefaultJudge();
        cells = new ArrayList<Cell>();
        grid = new DefaultGrid(judge);
        cell = new Cell(1,2);
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
        cells.add(new Cell(1,2));
        grid.populate(cells);

        //Act
        Boolean isAlive = judge.isAlive(neighbors, grid, cell);

        //Assert
        assertFalse(isAlive);
    }

    @Test
    public void isAliveReturnsTrueWhenCellHasTwoOrMoreNeighbors() {
        //Arrange
        cells.add(new Cell(1,2));
        cells.add(new Cell(2,2));
        cells.add(new Cell(1,1));
        grid.populate(cells);

        //Act
        Boolean isAlive = judge.isAlive(neighbors, grid, cell);

        //Assert
        assertTrue(isAlive);
    }

    @Test
    public void isAliveReturnsFalseWhenCellHasMoreThanThreeNeighbors() {
        //Arrange
        cells.add(new Cell(0,1));
        cells.add(new Cell(2,2));
        cells.add(new Cell(1,1));
        cells.add(new Cell(2,1));
        grid.populate(cells);

        //Act
        Boolean isAlive = judge.isAlive(neighbors, grid, cell);

        //Assert
        assertFalse(isAlive);
    }

    @Test
    public void DeadCellStaysDeadWhenSurroundedByTwoOrLessLiveNeighbors() {
        //Arrange
        cell.setAlive(false);
        cells.add(new Cell(2,2));
        cells.add(new Cell(1,1));
        grid.populate(cells);

        //Act
        Boolean isAlive = judge.isAlive(neighbors, grid, cell);

        //Assert
        assertFalse(isAlive);

    }
}
