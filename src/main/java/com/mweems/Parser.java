package com.mweems;

import java.awt.*;
import java.util.ArrayList;

public interface Parser {

    ArrayList<Point> parseString(String userInput);

    String parseGrid(Grid grid);
}
