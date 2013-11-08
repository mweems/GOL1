package com.mweems;

import java.util.ArrayList;

public class CLI implements UserInterface {

    private Prompter prompter;
    private StringParser stringParser;
    private Grid grid;

    public CLI(Prompter prompter, StringParser stringParser, Grid grid) {
        this.prompter = prompter;
        this.stringParser = stringParser;
        this.grid = grid;
    }

    @Override
    public void run() {
        String userInput = prompter.promptForCellLocations();
        ArrayList<Cell> cells = stringParser.parseCellLocations(userInput);
        grid.populate(cells);
        String gridCellsAsString = stringParser.parseGrid(grid);
    }
}
