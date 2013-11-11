package com.mweems;

import java.util.ArrayList;
import java.util.List;

public class DefaultGrid implements Grid {

    private List<Cell> cells = new ArrayList<Cell>();

    @Override
    public void populate(List<Cell> cells) {
        this.cells = cells;
    }

    @Override
    public List<Cell> getCells() {
        return cells;
    }
}
