package com.mweems;

import java.util.List;

public interface Grid {

    void populate(List<Cell> cells);

    List<Cell> getCells();

    List<Cell> tick(int iterations);

    String toString();
}
