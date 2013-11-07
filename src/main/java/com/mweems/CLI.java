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
        String userInput = prompter.promptForCellLocations();
        ArrayList<Point> points = stringParser.parseCellLocations(userInput);
        String numIterations = prompter.promptForNumIterations();
        int iterations = stringParser.parseIterations(numIterations);
        grid.populate(points);
    }
}
