package com.mweems;

import com.google.inject.Inject;

import java.util.List;

public class DefaultGameOfLife implements GameOfLife {

    private CLI cli;
    private Parser parser;
    private Grid grid;

    @Inject
    public DefaultGameOfLife(CLI cli, Parser parser, Grid grid) {
        this.cli = cli;
        this.parser = parser;
        this.grid = grid;
    }

    @Override
    public void run() {
        grid.populate(getCells());
        grid.tick(getIterations());
        grid.populate(grid.getCells());

        displayOutput(grid.toString());
    }

    @Override
    public List<Cell> getCells() {
        try{
            String cells = cli.promptForCellLocations();
            return parser.parseCellLocations(cells);
        } catch (NumberFormatException e){
            cli.displayError("Only Numbers allowed as Cell Locations ie. '1,1 1,2'");
            String cells = cli.promptForCellLocations();
            return parser.parseCellLocations(cells);
        }
    }

    @Override
    public int getIterations() {
        try{
            String iterations = cli.promptForNumIterations();
            return  parser.parseNumIterations(iterations);
        } catch (NumberFormatException e) {
            cli.displayError("Only Numbers allowed for Number of Iterations");
            String iterations = cli.promptForNumIterations();
            return parser.parseNumIterations(iterations);
        }
    }

    @Override
    public void displayOutput(String gridAsString) {
        cli.displayOutPut(gridAsString);
    }
}
