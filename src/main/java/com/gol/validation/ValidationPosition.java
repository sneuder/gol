package com.gol.validation;

import java.util.ArrayList;

import com.gol.globalException.*;

public class ValidationPosition {
    private String propName;

    private Integer rowsAmount;
    private Integer columnsAmount;

    private ArrayList<Integer[]> parsedDefaultCellsAlived;

    public ValidationPosition(String propName, Integer rowsAmount, Integer columnsAmount) {
        this.propName = propName;
        this.rowsAmount = rowsAmount;
        this.columnsAmount = columnsAmount;
    }

    public Boolean validate(String position) throws GlobalException {
        if (!this.validateDefaultCellsAlived(position)) {
            String message = this.propName + " must be a valid position.";
            throw new GlobalException(message, ErrorMessage.DATA_TYPE_INTEGER);
        }

        this.parsedDefaultCellsAlived = this.parseDefaultCellsAlived(position);
        return true;
    }

    public ArrayList<Integer[]> getParsedDefaultCellsAlived() {
        return this.parsedDefaultCellsAlived;
    }

    private Boolean validateDefaultCellsAlived(String defaultCellsAlived) {
        String PATTERN_POSITION_CELLS = "\\(\\d+,\\d+\\)(\\(\\d+,\\d+\\))*";
        return defaultCellsAlived.matches(PATTERN_POSITION_CELLS);
    }

    private Boolean validateRangeRow(Integer row) {
        return (row >= 1 && row <= this.rowsAmount);
    }

    private Boolean validateRangeColumn(Integer column) {
        return (column >= 1 && column <= this.columnsAmount);
    }

    private ArrayList<Integer[]> parseDefaultCellsAlived(String defaultCellsAlived) throws GlobalException {
        defaultCellsAlived = defaultCellsAlived.replaceAll("\\(", ",");
        defaultCellsAlived = defaultCellsAlived.replaceAll("\\)", ",");
        String[] positionsBase = defaultCellsAlived.split(",");

        ArrayList<String> positions = new ArrayList<>();
        for (String position: positionsBase) {
            if (position.isEmpty()) continue;
            positions.add(position);
        }

        ArrayList<Integer[]> parsedPositions = new ArrayList<>();

        for (int i = 0; i < positions.size(); i += 2) {
            String position = positions.get(i);
            if (position.isEmpty()) continue;

            Integer[] parsedPosition = new Integer[2];

            Integer row = Integer.parseInt(position);
            Integer columns = Integer.parseInt(positions.get(i + 1));

            if (!this.validateRangeRow(row)) {
                String message = "Invalid row position.";
                throw new GlobalException(message, ErrorMessage.DATA_TYPE_INTEGER_RANGE);
            }

            if (!this.validateRangeColumn(columns)) {
                String message = "Invalid column position.";
                throw new GlobalException(message, ErrorMessage.DATA_TYPE_INTEGER_RANGE);
            }

            parsedPosition[0] = row;
            parsedPosition[1] = columns;
            parsedPositions.add(parsedPosition);
        }

        return parsedPositions;
    }
}
