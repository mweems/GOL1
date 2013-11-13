package com.mweems;

import java.util.List;

public class DefaultGrid implements Grid {

    List<Cell> cells;

    @Override
    public void populate(List<Cell> cells) {
        this.cells = cells;
    }

    @Override
    public List<Cell> getCells() {
        return cells;
    }

    @Override
    public String toString() {
        String cellLocations = "";
        for(Cell cell : cells){
            cellLocations += cell.toString();
            if(!cell.equals(cells.get(cells.size()-1))) cellLocations += " ";
        }
        return cellLocations;
    }

}
