package com.mweems;

import java.awt.*;
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
        ArrayList<Point> points = stringParser.parseCellLocations(prompt());
        grid.populate(points);
        String gridCellsAsString = stringParser.parseGrid(grid);
    }

    private String prompt() {
        return prompter.prompt();
    }
}
