package com.mweems;

public interface CLI {

    String promptForCellLocations();

    String promptForNumIterations();

    void displayOutPut(String cellLocationsAsString);

    void displayErrorMessage(String message);

}
