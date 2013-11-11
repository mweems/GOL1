package com.mweems;

import java.util.ArrayList;
import java.util.List;

public class DefaultParser implements Parser{

    @Override
    public List<Cell> parseCellLocations(String cellLocations) {
        List<Cell> cells = new ArrayList<Cell>();
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
        String cellLocationsAsString = "";
        List<Cell> cells;
        cells = grid.getCells();
        for(Cell cell : cells){
            cellLocationsAsString += cell.toString();
        }
        return cellLocationsAsString;
    }
}
