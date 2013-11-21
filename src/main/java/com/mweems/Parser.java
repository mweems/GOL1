package com.mweems;

import java.util.ArrayList;

public interface Parser {

    ArrayList<int[]> parseString(String userInput);

    String parseGrid(Grid grid);
}
