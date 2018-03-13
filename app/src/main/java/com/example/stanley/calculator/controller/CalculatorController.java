package com.example.stanley.calculator.controller;

/**
 * Created by stanley on 2018-03-12.
 */

public class CalculatorController {

    public String calculate(String first, String second, char operator) {
        String result;
        Double number;

        switch (operator) {
            case '+':
                number = add(first, second);
                result = String.format("%.2f", number);
                break;
            case '-':
                number = subtract(first, second);
                result = String.format("%.2f", number);
                break;
            case '*':
                number = multiply(first, second);
                result = String.format("%.2f", number);
                break;
            case '/':
                if (isDivisible(second)) {
                    number = divide(first, second);
                    result = String.format("%.2f", number);
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

    private Double add(String first, String second) {
        return Double.parseDouble(first) + Double.parseDouble(second);
    }

    private Double subtract(String first, String second) {
        return Double.parseDouble(first) - Double.parseDouble(second);
    }

    private Double multiply(String first, String second) {
        return Double.parseDouble(first) * Double.parseDouble(second);
    }

    private Double divide(String first, String second) {
        return Double.parseDouble(first) / Double.parseDouble(second);
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
