package com.mweems;

import java.util.ArrayList;
import java.util.List;

public class DefaultParser implements Parser{

    @Override
    public List<Cell> parseCellLocations(String cellLocations) {
        List<Cell> cells = new ArrayList<Cell>();
        String[] cellLocationsPaired = cellLocations.split(" ");
        for(String cellPair : cellLocationsPaired){
            String[] splitCellLocations = cellPair.split(",");
            int x = Integer.parseInt(splitCellLocations[0]);
            int y = Integer.parseInt(splitCellLocations[1]);
            cells.add(new Cell(x, y));
        }
        return cells;
    }

    @Override
    public int parseNumIterations(String numIterations) {
        return Integer.parseInt(numIterations);
    }
}
