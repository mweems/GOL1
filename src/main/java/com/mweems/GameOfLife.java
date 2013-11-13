package com.mweems;

import java.util.List;

public interface GameOfLife {

    void run();

    List<Cell> getCells();

    int getIterations();

    void displayOutput(String gridAsString);
}
