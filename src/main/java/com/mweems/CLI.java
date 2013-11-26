package com.mweems;

public interface CLI {

    String promptForCellLocations();

    void displayOutPut(String cellLocationsAsString);

    String promptForNumIterations();

    void displayError(String message);

}
