package com.mweems;

import java.util.List;

public class DefaultJudge implements Judge {

    private final int MINLIVENEIGHBORS = 2;
    private final int MAXLIVENEIGHBORS = 3;

    @Override
    public boolean isAlive(Cell cell, List<Cell> neighbors, Grid grid) {
        int liveNeighbors = 0;
        for(Cell neighborCell : neighbors){
            if(grid.contains(neighborCell)) liveNeighbors++;
        }
        if(cell.isAlive()) {
            return alive(liveNeighbors);
        } else {
            return dead(liveNeighbors);
        }
    }

    private boolean dead(int liveNeighbors) {
        if(liveNeighbors == MAXLIVENEIGHBORS) return true;
        return false;
    }

    private boolean alive(int liveNeighbors) {
        if(liveNeighbors < MINLIVENEIGHBORS || liveNeighbors > MAXLIVENEIGHBORS) return false;
        return true;
    }
}
