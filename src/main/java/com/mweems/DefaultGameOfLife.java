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
        int numIterations = getIterations();
        grid.populate(grid.tick(numIterations));

        displayOutput(grid.toString());
    }

    @Override
    public List<Cell> getCells() {
        List<Cell> parsedCells;
        try{
            String cells = cli.promptForCellLocations();
            parsedCells = parser.parseCellLocations(cells);
        } catch (NumberFormatException e){
            String cells = cli.displayError();
            parsedCells = parser.parseCellLocations(cells);
        }
        return parsedCells;
    }

    @Override
    public int getIterations() {
        String iterations = cli.promptForNumIterations();
        return parser.parseNumIterations(iterations);
    }

    @Override
    public void displayOutput(String gridAsString) {
        cli.displayOutPut(gridAsString);
    }
}
