package com.mweems;

import java.util.List;

public interface GameOfLife {

    void run();

    List<Cell> getCellLocationsFromUser();

    int getIterationsFromUser();

    void displayOutput(String gridAsString);
}
