package com.javamentor.test.service;

public class StubInput implements Input {

    private String value;

    public StubInput(String value) {
        this.value = value;
    }

    @Override
    public String ask(String question) {
        return this.value;
    }

    @Override
    public String answer(String answer) {
        return this.value;
    }
}
