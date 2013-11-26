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
        grid.tick(getIterationsFromUser());
        displayOutput(grid.toString());
    }

    private List<Cell> getCellLocationsFromUser() {
        try{
            String cells = cli.promptForCellLocations();
            return parser.parseCellLocations(cells);
        } catch (NumberFormatException e){
            cli.displayError("Only Numbers allowed as Cell Locations ie. '1,1 1,2'");
            return getCellLocationsFromUser();
        }
    }

    private int getIterationsFromUser() {
        try{
            String iterations = cli.promptForNumIterations();
            return  parser.parseNumIterations(iterations);
        } catch (NumberFormatException e) {
            cli.displayError("Only Numbers allowed for Number of Iterations");
            return getIterationsFromUser();
        }
    }


    private void displayOutput(String gridAsString) {
        cli.displayOutPut(gridAsString);
    }
}
