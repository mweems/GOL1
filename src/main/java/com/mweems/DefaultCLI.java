package com.mweems;

import java.util.Scanner;

public class DefaultCLI implements CLI {

    @Override
    public String promptForCellLocations() {
      return promptForInput("Enter Cell Locations:");
    }

    @Override
    public String promptForNumIterations() {
        return promptForInput("Enter Number of Iterations:");
    }

    @Override
    public void displayOutPut(String cellLocationsAsString) {
        if(cellLocationsAsString == "") System.out.println("No Living Cells");
        System.out.print(cellLocationsAsString);
    }

    @Override
    public void displayErrorMessage(String message) {
        System.out.println(message);
    }

    private String promptForInput(String message){
        Scanner userInput = new Scanner(System.in);
        System.out.print(message);
        return userInput.nextLine();
    }
}
