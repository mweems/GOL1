package com.mweems;

import java.util.List;

public class DefaultGameOfLife implements GameOfLife {

    private CLI CLI;
    private Parser parser;
    private Grid grid;

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
        String gridCellsAsString = parser.parseGrid(grid);
        CLI.displayOutPut(gridCellsAsString);
    }
}
