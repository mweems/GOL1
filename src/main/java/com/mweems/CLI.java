package com.mweems;

import java.awt.*;
import java.util.ArrayList;

public class CLI implements UserInterface {

    private UserInteraction userInteraction;
    private Parser parser;
    private Grid grid;

    public CLI(UserInteraction userInteraction, Parser parser, Grid grid) {
        this.userInteraction = userInteraction;
        this.parser = parser;
        this.grid = grid;
    }

    @Override
    public void run() {
        String userInput = userInteraction.promptForCellLocations();
        ArrayList<Point> points = parser.parseString(userInput);
        grid.populate(points);
        String cellLocationsAsString = parser.parseGrid(grid);
        userInteraction.displayOutput(cellLocationsAsString);
    }
}
