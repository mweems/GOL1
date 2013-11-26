package com.mweems;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class DefaultGrid implements Grid {

    List<Cell> cells = new ArrayList<Cell>();
    Judge judge;

    @Inject
    public DefaultGrid(Judge judge) {
        this.judge = judge;
    }

    @Override
    public void populate(List<Cell> cells) {
        this.cells = cells;
    }

    @Override
    public List<Cell> getCells() {
        return cells;
    }

    @Override
    public void tick(int iterations) {
        List<Cell> nextGen = new ArrayList<Cell>();
        for(int i = 0; i < iterations; i++){
            judgeCells(nextGen);
        }
        this.cells = nextGen;
    }

    @Override
    public String toString() {
        String cellLocations = "";
        for(Cell cell : cells){
            cellLocations += cell.toString();
            if(thisCellIsNotLastCell(cell)) cellLocations += " ";
        }
        return cellLocations;
    }
    private void judgeCells(List<Cell> nextGen) {
        for(Cell cell : cells) {
            List<Cell> neighbors = getNeighbors(cell);
            if(judge.isAlive(cell, neighbors, this) && !nextGen.contains(cell)) {
                nextGen.add(cell);
            }
            judgeDeadCells(nextGen, neighbors);
        }
    }

    private void judgeDeadCells(List<Cell> nextGen, List<Cell> neighbors) {
        for(Cell neighborCell : neighbors){
            List<Cell> otherNeighbors = getNeighbors(neighborCell);
            if(judge.isAlive(neighborCell, otherNeighbors, this) && !nextGen.contains(neighborCell)){
                neighborCell.setAlive(true);
                nextGen.add(neighborCell);
            }
        }
    }

    private boolean thisCellIsNotLastCell(Cell cell) {
        return !cell.equals(cells.get(cells.size()-1));
    }

    private List<Cell> getNeighbors(Cell cell) {
        List<Cell> neighbors = new ArrayList<Cell>();
        neighbors.add(new Cell(cell.getX()-1,cell.getY()-1));
        neighbors.add(new Cell(cell.getX()-1,cell.getY()));
        neighbors.add(new Cell(cell.getX()-1,cell.getY()+1));
        neighbors.add(new Cell(cell.getX(),cell.getY()-1));
        neighbors.add(new Cell(cell.getX(),cell.getY()+1));
        neighbors.add(new Cell(cell.getX()+1,cell.getY()-1));
        neighbors.add(new Cell(cell.getX()+1,cell.getY()));
        neighbors.add(new Cell(cell.getX()+1,cell.getY()+1));

        for(Cell neighborCell:neighbors){
            neighborCell.setAlive(false);
        }
        return neighbors;
    }
}
