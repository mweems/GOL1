package com.mweems;

import java.util.List;

public interface Judge {

    boolean isAlive(Cell cell, List<Cell> neighbors, Grid grid);
}
