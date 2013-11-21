package com.mweems;

import java.util.Scanner;

public class DefaultCLI implements CLI {

    @Override
    public String promptForCellLocations() {
      return prompt("Enter Cell Locations:");
    }

    @Override
    public void displayOutPut(String cellLocationsAsString) {
        System.out.print(cellLocationsAsString);
    }

    @Override
    public String promptForNumIterations() {
        return prompt("Enter Number of Iterations:");
    }

    private String prompt(String message){
        Scanner userInput = new Scanner(System.in);
        System.out.print(message);
        return userInput.nextLine();
    }
}
