package com.mweems;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;

public class DefaultCLITest {

    @Test
    public void displayGridAsString() {
        //Arrange
        DefaultCLI CLI = new DefaultCLI();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        //Act
        CLI.displayOutPut("grid as string");

        //Assert
        assertEquals("grid as string", outContent.toString());
    }
}
