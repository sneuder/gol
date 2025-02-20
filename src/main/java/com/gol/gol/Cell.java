package com.gol.gol;

enum CellState {
    DEAD,
    ALIVE
}

public class Cell {
    private Integer id;
    private CellState state;
    private Integer[] neighbors = {};

    public Cell(int id, CellState state) {
        this.setId(id);
        this.setState(state);
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CellState getState() {
        return state;
    }
   
    public void setState(CellState state) {
        this.state = state;
    }

    public Integer[] getNeighbors() {
        return this.neighbors;
    }

    public void setNeighbors(Integer[] neighbors) {
        this.neighbors = neighbors;
    }

    public Boolean isAlive() {
        return this.state == CellState.ALIVE;
    }
}
