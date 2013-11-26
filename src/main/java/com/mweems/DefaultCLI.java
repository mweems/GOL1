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

    @Override
    public String displayCellLocationErrorAndPrompt() {
        System.out.println("Only Numbers allowed as Cell Locations ie. '1,1 1,2'");
        return promptForCellLocations();
    }

    @Override
    public String displayIterationErrorAndPrompt() {
        System.out.println("Only Numbers allowed for Number Of Iterations");
        return promptForNumIterations();
    }

    private String prompt(String message){
        Scanner userInput = new Scanner(System.in);
        System.out.print(message);
        return userInput.nextLine();
    }
}
