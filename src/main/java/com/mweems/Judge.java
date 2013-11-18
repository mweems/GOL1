package com.mweems;

import java.util.List;

public interface Judge {

    boolean isAlive(List<Cell> neighbors, Grid grid, Cell cell);
}
