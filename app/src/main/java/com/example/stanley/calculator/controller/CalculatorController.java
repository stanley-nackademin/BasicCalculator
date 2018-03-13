package com.example.stanley.calculator.controller;

/**
 * Created by stanley on 2018-03-12.
 */

public class CalculatorController {

    public String calculate(String first, String second, char operator) {
        String result;

        switch (operator) {
            case '+':
                result = add(first, second);
                break;
            case '-':
                result = subtract(first, second);
                break;
            case '*':
                result = multiply(first, second);
                break;
            case '/':
                if (isDivisible(second)) {
                    result = divide(first, second);
                } else {
                    result = "Can't divide by 0";
                }
                break;
            default:
                result = "Unknown error";
                break;
        }
        return result;
    }

    public boolean isValidInput(String firstText, String secondText) {
        if (!firstText.isEmpty() && !secondText.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private String add(String first, String second) {
        return Double.toString(Double.parseDouble(first) + Double.parseDouble(second));
    }

    private String subtract(String first, String second) {
        return Double.toString(Double.parseDouble(first) - Double.parseDouble(second));
    }

    private String multiply(String first, String second) {
        return Double.toString(Double.parseDouble(first) * Double.parseDouble(second));
    }

    private String divide(String first, String second) {
        return Double.toString(Double.parseDouble(first) / Double.parseDouble(second));
    }

    private boolean isDivisible(String second) {
        Double number = Double.parseDouble(second);

        if (number == 0) {
            return false;
        } else {
            return true;
        }
    }
}
