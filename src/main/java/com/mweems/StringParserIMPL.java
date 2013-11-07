package com.mweems;

import java.awt.*;
import java.util.ArrayList;

public class StringParserIMPL implements StringParser {

    private StringToInt sti;

    public StringParserIMPL(StringToInt sti) {
        this.sti = sti;
    }

    @Override
    public ArrayList<Point> parseCellLocations(String cellLocations) {
        ArrayList<Integer> cellLocationsAsIntegers = sti.intValueOf(cellLocations);
        return intToPoints(cellLocationsAsIntegers);
    }

    private ArrayList<Point> intToPoints(ArrayList<Integer> cellLocationsAsIntegers) {
        ArrayList<Point> cellLocationsAsPoints = new ArrayList<Point>();
        for(int i = 0; i < cellLocationsAsIntegers.size(); i = i + 2){
            cellLocationsAsPoints.add(new Point(cellLocationsAsIntegers.get(i),cellLocationsAsIntegers.get(i +1)));
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
