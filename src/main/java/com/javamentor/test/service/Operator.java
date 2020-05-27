package com.javamentor.test.service;

import com.javamentor.test.exceptions.OperationFormatException;

import java.util.HashMap;
import java.util.Map;

public class Operator {

    private final Map<String, Func> map = new HashMap<>();
    private final RomanNumber romanNumber = new RomanNumber();

    {
        map.put("+", new Addition());
        map.put("-", new Subtraction());
        map.put("*", new Multiplication());
        map.put("/", new Division());
    }

    public void contains(String str) throws OperationFormatException {
        if (!map.containsKey(str)) {
            throw new OperationFormatException();
        }
    }

    public String getAnswer(int num1, String op, int num2, boolean isRoman) {
        if (isRoman) {
            return romanNumber.arabicToRoman(map.get(op).make(num1, num2));
        } else {
            return Integer.toString(map.get(op).make(num1, num2));
        }
    }

    class Addition  implements Func {
        @Override
        public int make(int a, int b) {
            return a + b;
        }
    }

    class Subtraction implements Func {
        @Override
        public int make(int a, int b) {
            return  a - b;
        }
    }

    class Multiplication implements Func {
        @Override
        public int make(int a, int b) {
            return  a * b;
        }
    }

    class Division implements Func {
        @Override
        public int make(int a, int b) {
            return  a / b;
        }
    }
}
