package com.javamentor.test.service;

import com.javamentor.test.exceptions.OperationFormatException;

public class Parser {

    private int first, second;
    private String operation;
    private final Operator operator = new Operator();
    private boolean isRoman;

    public void parse(String s) throws OperationFormatException {
        String[] str = new String[3];
        int i = 0;
        for (String part : s.split(" ")) {
            str[i] = part.toUpperCase();
            i++;
        }
        this.check(str);
    }

    private void check(String[] input) throws OperationFormatException {
        RomanNumber romanNumber = new RomanNumber();

        if (!(romanNumber.isRoman(input[0]) && romanNumber.isRoman(input[2]))) {
            if ((Integer.parseInt(input[0]) >= 1) && (Integer.parseInt(input[0]) <= 10)
                    &&
                ((Integer.parseInt(input[2]) >= 1) && (Integer.parseInt(input[2]) <= 10)))
            {
                first = Integer.parseInt(input[0]);
                second = Integer.parseInt(input[2]);
                this.isRoman = false;
            } else throw new NumberFormatException("Числа должны быть от 0 до 10");
        } else {
            first = romanNumber.getNumber(input[0]);
            second = romanNumber.getNumber(input[2]);
            this.isRoman = true;
        }
        operator.contains(input[1]);
        this.operation = input[1];
    }

    public String getResult() {
        return operator.getAnswer(first, operation, second, isRoman);
    }
}
