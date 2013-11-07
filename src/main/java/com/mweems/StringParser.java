package com.mweems;

import java.awt.*;
import java.util.ArrayList;

public interface StringParser {

    ArrayList<Point> parseCellLocations(String cellLocations);

    int parseIterations(String numIterations);
}
