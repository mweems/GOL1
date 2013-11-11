package com.mweems;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CellTest {

    @Test
    public void cellsWithSameCoordinatesAreEqual() {
        //Arrange
        Cell cell1A = new Cell(1,2);
        Cell cell1B = new Cell(1,2);
        Cell cell2 = new Cell(2,1);

        //Assert
        assertEquals(cell1A, cell1B);
        assertNotEquals(cell1A, cell2);
    }

    @Test
    public void cellsWithSameCoordinatesHaveEqualHashCodes() {
        //Arrange
        Cell cell1A = new Cell(1,2);
        Cell cell1B = new Cell(1,2);
        Cell cell2 = new Cell(2,1);

        //Assert
        assertEquals(cell1A.hashCode(), cell1B.hashCode());
        assertNotEquals(cell1A.hashCode(), cell2.hashCode());
    }

    @Test
    public void cellsOverrideToStringWithCustomToString() {
        //Arrange
        Cell cell = new Cell(1,2);

        //Assert
        assertEquals("1,2", cell.toString());
    }
}
