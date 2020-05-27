package com.javamentor.test;

import com.javamentor.test.exceptions.OperationFormatException;
import com.javamentor.test.service.ConsoleInput;
import com.javamentor.test.service.Input;
import com.javamentor.test.service.Parser;

import java.util.function.Consumer;

public class Calculator {

    private final Parser parser;
    private final Consumer<String> output;
    private final Input input;
    private boolean toggle = true;

    public Calculator(Input input, Parser parser, Consumer<String> output) {
        this.input = input;
        this.parser = parser;
        this.output = output;
    }

    public void init(boolean flag) throws OperationFormatException {
        while (toggle) {
            String s = input.ask("Input:");
            parser.parse(s);
            input.answer("Output: \n" + parser.getResult());
            toggle = flag;
        }
    }

    public static void main(String[] args) throws OperationFormatException {
        new Calculator(new ConsoleInput(), new Parser(), System.out::println).init(true);
    }
}