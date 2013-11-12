package com.mweems;

public class DefaultCLI implements CLI {


    @Override
    public String promptForCellLocations() {
        return null;
    }

    @Override
    public void displayOutPut(String cellLocationsAsString) {
        System.out.print(cellLocationsAsString);
    }
}
