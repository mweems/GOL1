package com.mweems;

import java.util.List;

public interface Grid {

    void populate(List<Cell> cells);

    void tick(int iterations);

    boolean contains(Cell neighborCell);
}
