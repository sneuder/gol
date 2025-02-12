package com.gol.gol;

import java.util.ArrayList;
import java.util.HashMap;

public class GOL {
    private Grid grid;
    private Params params;

    public GOL(Params params) {
        this.setParams(params);

        Grid grid = new Grid(params.getRows(), params.getColumns());
        this.setGrid(grid);
        this.fillGridWithCells();
    }
    
    private void fillGridWithCells() {
        for (int i = 0; i < this.grid.getAmountOfCells(); i++) {
            boolean isCellAlived = this.includesInt(this.params.getDefaultCellsAlived(), i);
            if (!isCellAlived) continue;

            Cell cell = new Cell(i, CellState.ALIVE);
            grid.getGrid().put(i, cell);
        }
    }

    private boolean includesInt(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) return true;
        }
        return false;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    public int[] getNeighborsByCellId(int id) {
        int currentRow = (int) Math.ceil((double)(id + 1) / params.getRows());
        
        int toCellId = (currentRow * params.getColumns()) - 1;
        int fromCellId = (toCellId - params.getColumns()) + 1;

        int top = id - params.getColumns();
        int topLeft = -1;
        int topRight = -1;

        if (top >= 0) {
            if (id > fromCellId) topLeft = id - params.getColumns() - 1;
            if (id < toCellId) topRight = id - params.getColumns() + 1;
        } else {
            top = -1;
        }

        int amountOfCells = params.getRows() * params.getColumns();

        int bottom = id + params.getColumns();
        int bottomLeft = -1;
        int bottomRight = -1;

        if (bottom < amountOfCells - 1) {
            if (id > fromCellId) bottomLeft = id + params.getColumns() - 1;
            if (id < toCellId) bottomRight = id + params.getColumns() + 1;
        } else {
            bottom = -1;
        }

        int left = id - 1;
        int right = id + 1;

        if (!isWithinRange(left, fromCellId, toCellId)) left = -1;
        if (!isWithinRange(right, fromCellId, toCellId)) right = -1;

        return new int[]{top, topRight, right, bottomRight, bottom, bottomLeft, left, topLeft};
    }

    private boolean isWithinRange(int value, int min, int max) {
        return value >= min && value <= max;
    }

    public void liveGenerations() {
        for (int i = 0; i < params.getGenerations(); i++) {
            HashMap<Integer, Cell> copyGrid = this.grid.getCopyGrid();
            this.liveGeneration(copyGrid);
        }
    }

    public void liveGeneration(HashMap<Integer, Cell>  copyGrid) {
        for (int j = 0; j < this.grid.getAmountOfCells(); j++) { // change for optimization
            Cell cell;
            if (this.grid.getGrid().containsKey(j)) cell = copyGrid.get(j);
            else cell = new Cell(j, CellState.DEAD);

            if (cell.getNeighbors().length == 0) cell.setNeighbors(this.getNeighborsByCellId(cell.getId()));

            CellState newState = this.getCellStateRules(cell); 
            cell.setState(newState);

            copyGrid.put(j, cell);
        }

        this.grid.setGrid(copyGrid);
    }

    private CellState getCellStateRules(Cell cell) {
        ArrayList<Cell> aliveNeighbors = this.getActiveNeighbors(cell);
        int aliveNeighborsAmount = aliveNeighbors.size();

        if (cell.getState() == CellState.ALIVE && (aliveNeighborsAmount < 2 || aliveNeighborsAmount > 3)) return CellState.DEAD;
        if (cell.getState() == CellState.DEAD && aliveNeighborsAmount == 3) return CellState.ALIVE;

        return cell.getState();
    }

    private ArrayList<Cell> getActiveNeighbors(Cell cell) {
        ArrayList<Cell> neighbors = new ArrayList<>();

        for (int neighbor : cell.getNeighbors()) {
            if (neighbor < 0 || !this.grid.getGrid().containsKey(neighbor)) continue;
            Cell neighborCell = this.grid.getGrid().get(neighbor);
            if (neighborCell.getState() == CellState.ALIVE) neighbors.add(neighborCell);
        }

        return neighbors;
    }

    public void printGrid() {
        for (int i = 0; i < this.grid.getAmountOfCells(); i++) {
            if (this.grid.getGrid().containsKey(i)) {
                Cell cell = this.grid.getGrid().get(i);
                System.out.print(cell.getState() + " " + " ");
            } else System.out.print(CellState.DEAD + " ");

            if (i % this.grid.getColumns() == this.grid.getColumns() - 1) System.out.println();
        }

        System.out.println();
    }
}
