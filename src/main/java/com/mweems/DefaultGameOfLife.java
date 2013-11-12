package com.mweems;

import com.google.inject.Inject;

import java.util.List;

public class DefaultGameOfLife implements GameOfLife {

    private CLI CLI;
    private Parser parser;
    private Grid grid;

    @Inject
    public DefaultGameOfLife(CLI CLI, Parser parser, Grid grid) {
        this.CLI = CLI;
        this.parser = parser;
        this.grid = grid;
    }

    @Override
    public void run() {
        String userInput = CLI.promptForCellLocations();
        List<Cell> cells = parser.parseCellLocations(userInput);
        grid.populate(cells);
        String gridCells = grid.toString();
        CLI.displayOutPut(gridCells);
    }
}
