package com.mweems;

import org.junit.Test;

import static org.junit.Assert.*;

public class CellTest {

    @Test
    public void cellsWithSameCoordinatesAreEqual() {
        //Arrange
        Cell cell1A = new Cell(1,2,true);
        Cell cell1B = new Cell(1,2,true);
        Cell cell2 = new Cell(2,1,true);

        //Assert
        assertEquals(cell1A, cell1B);
        assertNotEquals(cell1A, cell2);
    }

    @Test
    public void cellsWithSameCoordinatesHaveEqualHashCodes() {
        //Arrange
        Cell cell1A = new Cell(1,2,true);
        Cell cell1B = new Cell(1,2,true);
        Cell cell2 = new Cell(2,1,true);

        //Assert
        assertEquals(cell1A.hashCode(), cell1B.hashCode());
        assertNotEquals(cell1A.hashCode(), cell2.hashCode());
    }

    @Test
    public void cellsOverrideToStringWithCustomToString() {
        //Arrange
        Cell cell = new Cell(1,2,true);

        //Assert
        assertEquals("1,2", cell.toString());
    }

    @Test
    public void cellsKnowWhetherTheyAreAliveOrDead() {
        //Arrange
        Cell cell1 = new Cell(1,2,true);
        Cell cell2 = new Cell(1,2,false);

        //Assert
        assertTrue(cell1.isAlive());
        assertFalse(cell2.isAlive());
    }


}
