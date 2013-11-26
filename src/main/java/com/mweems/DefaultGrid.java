package com.mweems;

import com.google.inject.Inject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DefaultGrid implements Grid {

    List<Cell> cells = new ArrayList<Cell>();
    List<Cell> nextGen = new ArrayList<Cell>();
    private final Judge judge;

    @Inject
    public DefaultGrid(Judge judge) {
        this.judge = judge;
    }

    @Override
    public void populate(List<Cell> cells) {
        this.cells = cells;
    }

    @Override
    public void tick(int iterations) {
        for(int i = 0; i < iterations; i++){
            judgeCells();
        }
        this.populate(nextGen);
    }

    @Override
    public boolean contains(Cell cell) {
        if(cells.contains(cell)) return true;
        return false;
    }

    @Override
    public List<Point> getListOfCellLocations(){
        List<Point> cellLocations = new ArrayList<Point>();
        for(Cell cell : cells){
            cellLocations.add(new Point(cell.getX(), cell.getY()));
        }
        return cellLocations;
    }


    private void judgeCells() {
        for(Cell cell : cells) {
            List<Cell> neighbors = getNeighbors(cell);
            if(judge.isAlive(cell, neighbors) && !nextGen.contains(cell)) {
                nextGen.add(cell);
            }
            judgeDeadCells(neighbors);
        }
    }

    private void judgeDeadCells(List<Cell> cells) {
        for(Cell cell : cells){
            List<Cell> neighbors = getNeighbors(cell);
            if(judge.isAlive(cell, neighbors) && !nextGen.contains(cell)){
                cell.setAlive(true);
                nextGen.add(cell);
            }
        }
    }

    private List<Cell> getNeighbors(Cell cell) {
        List<Cell> neighbors = new ArrayList<Cell>();
        neighbors.add(new Cell(cell.getX() - 1, cell.getY() - 1));
        neighbors.add(new Cell(cell.getX() - 1, cell.getY()));
        neighbors.add(new Cell(cell.getX() - 1, cell.getY() + 1));
        neighbors.add(new Cell(cell.getX(), cell.getY() - 1));
        neighbors.add(new Cell(cell.getX(), cell.getY() + 1));
        neighbors.add(new Cell(cell.getX() + 1, cell.getY() - 1));
        neighbors.add(new Cell(cell.getX() + 1, cell.getY()));
        neighbors.add(new Cell(cell.getX() + 1, cell.getY() + 1));

        for(Cell neighborCell:neighbors){
            if(!this.contains(neighborCell)) neighborCell.setAlive(false);
        }
        return neighbors;
    }
}
