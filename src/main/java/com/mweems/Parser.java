package com.mweems;

import java.util.List;

public interface Parser {

    List<Cell> parseCellLocations(String cellLocations);

    String parseGrid(Grid grid);
}
