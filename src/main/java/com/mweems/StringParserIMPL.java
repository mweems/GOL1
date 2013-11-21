package com.mweems;

import java.awt.*;
import java.util.ArrayList;

public class StringParserIMPL implements StringParser {

    private ToInt ti;

    public StringParserIMPL(ToInt ti) {
        this.ti = ti;
    }

    @Override
    public ArrayList<Point> parseCellLocations(String cellLocations) {
        ArrayList<Integer> cellLocationsAsIntegers = ti.intValueOfString(cellLocations);
        return intToPoints(cellLocationsAsIntegers);
    }

    @Override
    public int parseIterations(String numIterations) {
        ArrayList<Integer> numIterationsAsInteger = ti.intValueOfString(numIterations);
        return numIterationsAsInteger.get(0);
    }

    @Override
    public String parseGrid(Grid grid) {
        ArrayList<Integer> cellLocationsAsIntegers = ti.intValueOfGrid(grid);
        return intToString(cellLocationsAsIntegers);
    }

    private String intToString(ArrayList<Integer> cellLocationsAsIntegers) {
        String cellLocationsAsString = "";
        for(Integer value : cellLocationsAsIntegers){
            cellLocationsAsString += value.toString();
        }
        return cellLocationsAsString;
    }

    private ArrayList<Point> intToPoints(ArrayList<Integer> cellLocationsAsIntegers) {
        ArrayList<Point> cellLocationsAsPoints = new ArrayList<Point>();
        for(int i = 0; i < cellLocationsAsIntegers.size(); i = i + 2){
            cellLocationsAsPoints.add(new Point(cellLocationsAsIntegers.get(i),cellLocationsAsIntegers.get(i +1)));
        }
        return cellLocationsAsPoints;
    }
}
