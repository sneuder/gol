package com.gol.validation;

import com.gol.globalException.*;

public class ValidationNumber {
    private String propName;

    private Integer number;
    private String stringNumber;

    private Boolean positive;
    private Integer min;
    private Integer max;

    public ValidationNumber(String propName, Integer number, Boolean positive, Integer min, Integer max) {
        this.propName = propName;
        this.number = number;
        this.positive = positive;
        this.min = min;
        this.max = max;
    }

    public ValidationNumber(String propName, String number, Boolean positive, Integer min, Integer max) {
        this.propName = propName;
        this.stringNumber = number;
        this.positive = positive;
        this.min = min;
        this.max = max;
    }

    public Integer getNumber() {
        return this.number;
    }

    public Boolean validate() throws GlobalException {
        Integer number = this.castNumber();
        this.number = number;

        if (this.positive) {
            Boolean isPositive = this.validatePositiveNumber();
            if (!isPositive) {
                String message = this.propName + " must be a positive number.";
                throw new GlobalException(message, ErrorMessage.DATA_TYPE_INTEGER);
            }
        }

        if (this.min != null && this.max != null) {
            Boolean isInRange = this.validateRangeNumber();
            if (!isInRange) {
                String message = this.propName + " must be between " + this.min + " and " + this.max + ".";
                throw new GlobalException(message, ErrorMessage.DATA_TYPE_INTEGER_RANGE);
            }
        }

        return true;
    }

    private Integer castNumber() throws GlobalException {
        if (this.stringNumber == null)
            return this.number;
        if (this.stringNumber == "") {
            String message = this.propName + " cannot be empty.";
            throw new GlobalException(message, ErrorMessage.DATA_NOT_EMPTY);
        }

        Integer castedValue;
        try {
            castedValue = Integer.parseInt(this.stringNumber);
        } catch (NumberFormatException e) {
            String message = this.propName + " cannot be casted.";
            throw new GlobalException(message, ErrorMessage.DATA_TYPE_INTEGER);
        }

        return castedValue;
    }

    private Boolean validatePositiveNumber() {
        return this.number >= 0;
    }

    private Boolean validateRangeNumber() {
        return this.number >= this.min && this.number <= this.max;
    }
}
