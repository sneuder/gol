package com.gol.gol;

public class Params {
    private int rows;
    private int columns;
    private int generations;
    private int[] defaultCellsAlived;

    public Params(int rows, int columns, int generation, int[] defaultCellsAlived) {
        this.setRows(rows);
        this.setColumns(columns);
        this.setGenerations(generation);
        this.setDefaultCellsAlived(defaultCellsAlived);
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

    public int getGenerations() {
        return this.generations;
    }

    public void setGenerations(int generations) {
        this.generations = generations;
    }

    public int[] getDefaultCellsAlived() {
        return this.defaultCellsAlived;
    }

    public void setDefaultCellsAlived(int[] defaultCellsAlived) {
        this.defaultCellsAlived = defaultCellsAlived;
    }
}
