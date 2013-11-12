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
        String userInput = cli.promptForCellLocations();
        List<Cell> cells = parser.parseCellLocations(userInput);
        grid.populate(cells);
        String gridCells = grid.toString();
        cli.displayOutPut(gridCells);
    }
}
