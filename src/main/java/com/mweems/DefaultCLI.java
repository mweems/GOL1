package com.mweems;

import java.util.Scanner;

public class DefaultCLI implements CLI {

    @Override
    public String promptForCellLocations() {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter cell locations:");
        return userInput.nextLine();
    }

    @Override
    public void displayOutPut(String cellLocationsAsString) {
        System.out.print(cellLocationsAsString);
    }

    @Override
    public String promptForNumIterations() {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter Number of Iterations:");
        return userInput.nextLine();
    }
}
