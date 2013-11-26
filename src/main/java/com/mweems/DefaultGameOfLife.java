package com.mweems;

import com.google.inject.Inject;

import java.util.List;

public class DefaultGameOfLife implements GameOfLife {

    private final CLI cli;
    private final Parser parser;
    private final Grid grid;

    @Inject
    public DefaultGameOfLife(CLI cli, Parser parser, Grid grid) {
        this.cli = cli;
        this.parser = parser;
        this.grid = grid;
    }

    @Override
    public void run() {
        grid.populate(getCellLocationsFromUser());
        grid.tick(getNumberOfIterationsFromUser());
        displayOutput(grid.toString());
    }

    private List<Cell> getCellLocationsFromUser() {
        try{
            String cellLocations = cli.promptForCellLocations();
            return parser.parseCellLocations(cellLocations);
        } catch (NumberFormatException e){
            cli.displayErrorMessage("Only Numbers allowed as Cell Locations ie. '1,1 1,2'");
            return getCellLocationsFromUser();
        }
    }

    private int getNumberOfIterationsFromUser() {
        try{
            String numberOfIterations = cli.promptForNumIterations();
            return  parser.parseNumIterations(numberOfIterations);
        } catch (NumberFormatException e) {
            cli.displayErrorMessage("Only Numbers allowed for Number of Iterations");
            return getNumberOfIterationsFromUser();
        }
    }


    private void displayOutput(String locationsOfLiveCells) {
        cli.displayOutPut(locationsOfLiveCells);
    }
}
