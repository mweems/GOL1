package com.mweems;

import java.util.List;

public class DefaultJudge implements Judge {

    private int MINLIVENEIGHBORS = 2;
    private int MAXLIVENEIGHBORS = 3;

    @Override
    public boolean isAlive(List<Cell> neighbors, Grid grid) {
        int liveNeighbors = 0;
        for(Cell cell : neighbors){
            if(grid.getCells().contains(cell)) liveNeighbors++;
        }
        if(liveNeighbors < MINLIVENEIGHBORS || liveNeighbors > MAXLIVENEIGHBORS) return false;

        return true;
    }
}
