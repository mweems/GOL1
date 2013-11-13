package com.mweems;

import java.util.List;

public interface Parser {

    List<Cell> parseCellLocations(String cellLocations);

    int parseNumIterations(String numIterations);
}
