package com.mweems;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StringParserIMPL implements StringParser {

    private StringToInt sti;

    public StringParserIMPL(StringToInt sti) {
        this.sti = sti;
    }

    @Override
    public ArrayList<Point> parseCellLocations(String cellLocations) {
        HashMap<Integer, Integer> cellLocationsAsIntegers = sti.intValueOf(cellLocations);
        return intToPoints(cellLocationsAsIntegers);
    }

    private ArrayList<Point> intToPoints(HashMap<Integer, Integer> cellLocationsAsIntegers) {
        ArrayList<Point> cellLocationsAsPoints = new ArrayList<Point>();
        for(Map.Entry<Integer, Integer> cellLocation : cellLocationsAsIntegers.entrySet()){
            cellLocationsAsPoints.add(new Point(cellLocation.getKey(),cellLocation.getValue()));
        }
        return cellLocationsAsPoints;
    }

    @Override
    public int parseIterations(String numIterations) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String parseGrid(Grid grid) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
