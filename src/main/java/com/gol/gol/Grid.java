package com.gol.gol;

import java.util.HashMap;

public class Grid {
    private HashMap<Integer, Cell> grid = new HashMap<>();

    private int rows;
    private int columns;
    private int amountOfCells;

    public Grid(int rows, int columns) {
        this.setRows(rows);
        this.setColumns(columns);
        this.amountOfCells = this.getRows() * this.getColumns();

    }
    
    public HashMap<Integer, Cell> getGrid() {
        return grid;
    }

    public void setGrid(HashMap<Integer, Cell> grid) {
        this.grid = grid;
    }

    public int getRows() {
        return this.rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getAmountOfCells() {
        return this.amountOfCells;
    }

    public HashMap<Integer, Cell> getCopyGrid() {
        HashMap<Integer, Cell> grid = new HashMap<>();

        for (Integer key : this.grid.keySet()) {
            Cell cell = this.grid.get(key);
            grid.put(key, new Cell(cell.getId(), cell.getState()));
        }

        return grid;
    }
}
