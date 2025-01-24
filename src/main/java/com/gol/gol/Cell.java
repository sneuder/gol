package com.gol.gol;

enum CellState {
    DEAD,
    ALIVE
}

public class Cell {
    private int id;
    private CellState state;
    private int[] neighbors = {};

    public Cell(int id, CellState state) {
        this.setId(id);
        this.setState(state);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CellState getState() {
        return state;
    }
   
    public void setState(CellState state) {
        this.state = state;
    }

    public int[] getNeighbors() {
        return this.neighbors;
    }

    public void setNeighbors(int[] neighbors) {
        this.neighbors = neighbors;
    }
}
