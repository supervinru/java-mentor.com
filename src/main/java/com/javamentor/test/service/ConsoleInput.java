package com.javamentor.test.service;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    @Override
    public String answer(String answer) {
        System.out.println(answer);
        return "";
    }
}
