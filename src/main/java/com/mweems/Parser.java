package com.mweems;

import java.util.ArrayList;

public interface Parser {

    ArrayList<Cell> parseCellLocations(String cellLocations);

    String parseGrid(Grid grid);
}
