package com.mweems;

import java.util.List;

public class CLI implements UserInterface {

    private UserInteractions userInteractions;
    private Parser parser;
    private Grid grid;

    public CLI(UserInteractions userInteractions, Parser parser, Grid grid) {
        this.userInteractions = userInteractions;
        this.parser = parser;
        this.grid = grid;
    }

    @Override
    public void run() {
        String userInput = userInteractions.promptForCellLocations();
        List<Cell> cells = parser.parseCellLocations(userInput);
        grid.populate(cells);
        String gridCellsAsString = parser.parseGrid(grid);
        userInteractions.displayOutPut(gridCellsAsString);
    }
}
