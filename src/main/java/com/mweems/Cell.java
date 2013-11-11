package com.mweems;

public class Cell {

    private int xLoc;
    private int yLoc;

    public Cell(int xLoc, int yLoc) {
        this.xLoc = xLoc;
        this.yLoc = yLoc;
    }

    public int getXLoc() {
        return xLoc;
    }

    public int getYLoc() {
        return yLoc;
    }

    @Override
    public String toString(){
        return xLoc + "," + yLoc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (xLoc != cell.xLoc) return false;
        if (yLoc != cell.yLoc) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = xLoc;
        result = 31 * result + yLoc;
        return result;
    }
}
