package com.mweems;

import java.util.ArrayList;

public interface StringParser {

    ArrayList<Cell> parseCellLocations(String cellLocations);

    String parseGrid(Grid grid);
}
