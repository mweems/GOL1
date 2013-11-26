package com.mweems;

import java.util.List;

public class DefaultJudge implements Judge {

    private final int MINLIVENEIGHBORS = 2;
    private final int MAXLIVENEIGHBORS = 3;

    @Override
    public boolean isAlive(Cell cell, List<Cell> neighbors, Grid grid) {
        int livingNeighbors = 0;
        for(Cell neighborCell : neighbors){
            if(grid.contains(neighborCell)) livingNeighbors++;
        }
        if(cell.isAlive()) {
            return isAlive(livingNeighbors);
        } else {
            return isDead(livingNeighbors);
        }
    }

    private boolean isDead(int liveNeighbors) {
        if(liveNeighbors != MAXLIVENEIGHBORS) return false;
        return true;
    }

    private boolean isAlive(int liveNeighbors) {
        if(liveNeighbors < MINLIVENEIGHBORS || liveNeighbors > MAXLIVENEIGHBORS) return false;
        return true;
    }
}
