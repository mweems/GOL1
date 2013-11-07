package com.mweems;

import java.awt.*;
import java.util.ArrayList;

public class CLI implements UserInterface {

    private Prompter prompter;
    private StringParser stringParser;
    private Grid grid;
    private Outputter outputter;

    public CLI(Prompter prompter, StringParser stringParser, Grid grid, Outputter outputter) {
        this.prompter = prompter;
        this.stringParser = stringParser;
        this.grid = grid;
        this.outputter = outputter;
    }

    @Override
    public void run() {
        ArrayList<Point> points = stringParser.parseCellLocations(prompt());
        int iterations = stringParser.parseIterations(prompt());
        grid.populate(points);
        String gridCellsAsString = stringParser.parseGrid(grid);
        outputter.output(gridCellsAsString);
    }

    private String prompt() {
        return prompter.prompt();
    }
}
