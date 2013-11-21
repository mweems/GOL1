package com.mweems;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CellTest {

    private Cell cell1A;
    private Cell cell1B;
    private Cell cell2;

    @Before
    public void setup() {
        cell1A = new Cell(1,2);
        cell1B = new Cell(1,2);
        cell2 = new Cell(2,1);
    }

    @Test
    public void cellsWithSameCoordinatesAreEqual() {
        //Assert
        assertEquals(cell1A, cell1B);
        assertNotEquals(cell1A, cell2);
    }

    @Test
    public void cellsWithSameCoordinatesHaveEqualHashCodes() {
        //Assert
        assertEquals(cell1A.hashCode(), cell1B.hashCode());
        assertNotEquals(cell1A.hashCode(), cell2.hashCode());
    }

    @Test
    public void cellsOverrideToStringWithCustomToString() {
        //Assert
        assertEquals("1,2", cell1A.toString());
    }
}
