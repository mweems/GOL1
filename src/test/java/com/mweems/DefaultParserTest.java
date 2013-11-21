package com.mweems;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class DefaultParserTest {

    DefaultParser parser;

    @Before
    public void setup(){
        parser = new DefaultParser();
    }

    @Test
    public void parseStringArrayOfCells() {
        //Act
        List<Cell> cells = parser.parseCellLocations("1,2 3,4");

        //Assert
        assertEquals(2, cells.size());
        assertEquals(1, cells.get(0).getX());
        assertEquals(2, cells.get(0).getY());
        assertEquals(3, cells.get(1).getX());
        assertEquals(4, cells.get(1).getY());

    }

    @Test
    public void parsesStringToInt() {
        //Act
        int iterations = parser.parseNumIterations("1");

        //Assert
        assertEquals(1, iterations);
    }
}
