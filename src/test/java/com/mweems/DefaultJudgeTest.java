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
    private List<Cell> neighbors;

    @Before
    public void setup() {
        testCell = new Cell(1,2);
        judge = new DefaultJudge();
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
        setLiveNeighbors(cells);

        //Act
        Boolean isAlive = judge.isAlive(testCell, neighbors);

        //Assert
        assertFalse(isAlive);
    }

    @Test
    public void isAliveReturnsTrueWhenCellHasTwoLiveNeighbors() {
        //Arrange
        List<Cell> cells = Arrays.asList(testCell, new Cell(2,2), new Cell(1,1));
       setLiveNeighbors(cells);

        //Act
        Boolean isAlive = judge.isAlive(testCell, neighbors);

        //Assert
        assertTrue(isAlive);
    }

    @Test
    public void isAliveReturnsFalseWhenCellHasMoreThanThreeNeighbors() {
        //Arrange
        List<Cell> cells = Arrays.asList(new Cell(0,1), new Cell(2,2), new Cell(1,1), new Cell(2,1));
        setLiveNeighbors(cells);

        //Act
        Boolean isAlive = judge.isAlive(testCell, neighbors);

        //Assert
        assertFalse(isAlive);
    }

    @Test
    public void DeadCellStaysDeadWhenSurroundedByTwoOrLessLiveNeighbors() {
        //Arrange
        List<Cell> cells = Arrays.asList(new Cell(2,2), new Cell(1,1));
        testCell.setAlive(false);
        setLiveNeighbors(cells);

        //Act
        Boolean isAlive = judge.isAlive(testCell, neighbors);

        //Assert
        assertFalse(isAlive);
    }

    private void setLiveNeighbors(List<Cell> cells) {
        for(Cell cell : neighbors){
            if(!cells.contains(cell)) cell.setAlive(false);
        }
    }
}
