package com.mweems;

import java.util.List;

public interface Grid {

    void populate(List<Cell> cells);

    List<Cell> getCells();

    void tick(int iterations);

    String toString();
}
