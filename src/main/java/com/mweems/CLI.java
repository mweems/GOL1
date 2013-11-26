package com.mweems;

public interface CLI {

    String promptForCellLocations();

    String promptForNumIterations();

    void displayOutPut(Grid grid);

    void displayErrorMessage(String message);

}
