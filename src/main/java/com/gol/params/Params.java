package com.gol.params;

import java.util.ArrayList;

import com.gol.globalException.*;
import com.gol.validation.*;

public class Params {
    private Integer rows;
    private Integer columns;
    private Integer generations;
    private Integer milliseconds;
    private Integer[] defaultCellsAlived;

    public Params() { }

    public void setParamFromArgs(String[] args) throws GlobalException {
        if (args.length != 5) {
            String message = "Invalid number of arguments.";
            throw new GlobalException(message, ErrorMessage.DATA_PARAMS_AMOUNT);
        }

        var castedValues = this.validationsForNumberParams(args);
        var castedDefaultCellsAlived = this.validationForDefaultLivedCells(
            args[4],
            castedValues.get(0),
            castedValues.get(1)
        );
        
        this.setParams(
            castedValues.get(0),
            castedValues.get(1),
            castedValues.get(2),
            castedValues.get(3),
            castedDefaultCellsAlived
        );
    }

    private ArrayList<Integer> validationsForNumberParams(String[] args) throws GlobalException {
        ValidationNumber[] validationsNumber = { 
            new ValidationNumber("rows", args[0], true, 6, 100),
            new ValidationNumber("columns", args[1], true, 6, 100),
            new ValidationNumber("generations", args[2], true, 1, 1000),
            new ValidationNumber("milliseconds", args[3], true, 500, 5000)
        };

        ArrayList<Integer> castedValues = new ArrayList<>();

        for (ValidationNumber validationNumber: validationsNumber) {
            validationNumber.validate();
            castedValues.add(validationNumber.getNumber());
        }

        return castedValues;
    }

    private Integer[] validationForDefaultLivedCells(String defaultCellsAlived, Integer rowsAmount, Integer columnsAmount) throws GlobalException {
        ValidationPosition validationPosition = new ValidationPosition("defaultCellsAlived", rowsAmount, columnsAmount);
        validationPosition.validate(defaultCellsAlived);

        var parsedDefaultCellsAlived = validationPosition.getParsedDefaultCellsAlived();
        Integer[] castedDefaultCellsAlived = new Integer[parsedDefaultCellsAlived.size()];

        for (int i = 0; i < parsedDefaultCellsAlived.size(); i++) {
            Integer[] parsedDefaultCellAlived = parsedDefaultCellsAlived.get(i);

            Integer row = parsedDefaultCellAlived[0];
            Integer column = parsedDefaultCellAlived[1];

            if (row > rowsAmount) {
                String message = "Invalid row position.";
                throw new GlobalException(message, ErrorMessage.DATA_TYPE_INTEGER_RANGE);
            }

            if (column > columnsAmount) {
                String message = "Invalid column position.";
                throw new GlobalException(message, ErrorMessage.DATA_TYPE_INTEGER_RANGE);
            }

            Integer cellPosition = ((row - 1) * (columnsAmount)) + column;
            castedDefaultCellsAlived[i] = cellPosition;
        }

        return castedDefaultCellsAlived;
    }

    public void setParams(Integer rows, Integer columns, Integer generation, Integer milliseconds, Integer[] defaultCellsAlived) {
        this.setRows(rows);
        this.setColumns(columns);
        this.setGenerations(generation);
        this.setMilliseconds(milliseconds);
        this.setDefaultCellsAlived(defaultCellsAlived);
    }

    public Integer getRows() {
        return this.rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getColumns() {
        return this.columns;
    }

    public void setColumns(Integer columns) {
        this.columns = columns;
    }

    public Integer getGenerations() {
        return this.generations;
    }

    public void setGenerations(Integer generations) {
        this.generations = generations;
    }

    public Integer getMilliseconds() {
        return this.milliseconds;
    }

    public void setMilliseconds(Integer milliseconds) {
        this.milliseconds = milliseconds;
    }

    public Integer[] getDefaultCellsAlived() {
        return this.defaultCellsAlived;
    }

    public void setDefaultCellsAlived(Integer[] defaultCellsAlived) {
        this.defaultCellsAlived = defaultCellsAlived;
    }
}
