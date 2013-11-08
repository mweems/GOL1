package com.mweems;

import java.util.ArrayList;

public class DefaultParser implements Parser{

    @Override
    public ArrayList<Cell> parseCellLocations(String cellLocations) {
        ArrayList<Cell> cells = new ArrayList<Cell>();
        String[] cellLocationsPaired = cellLocations.split(" ");
        for(String cellPairs : cellLocationsPaired){
            String[] cellLocationsSplit = cellPairs.split(",");
            int xLoc = Integer.parseInt(cellLocationsSplit[0]);
            int yLoc = Integer.parseInt(cellLocationsSplit[1]);
            cells.add(new Cell(xLoc, yLoc));
        }
        return cells;
    }

    @Override
    public String parseGrid(Grid grid) {
        return null;  //not implemented yet
    }
}
