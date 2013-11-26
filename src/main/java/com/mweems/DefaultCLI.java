package com.mweems;

import java.awt.*;
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
    public void displayOutPut(Grid grid) {
            String listOfCellLocations = "";
        if(grid.getListOfCellLocations().isEmpty()){
            System.out.print("No Living Cells");
        } else {
            for(Point cellLocation : grid.getListOfCellLocations()){
                listOfCellLocations += cellLocation.toString();
            }
        }
        System.out.print(listOfCellLocations);
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
