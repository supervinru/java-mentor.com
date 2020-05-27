package com.javamentor.test;

import com.javamentor.test.exceptions.OperationFormatException;
import com.javamentor.test.service.Input;
import com.javamentor.test.service.Parser;
import com.javamentor.test.service.StubInput;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    private Parser parser;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };

    @Before
    public void before() {
        this.parser = new Parser();
    }

    @Test
    public void whenInputValidDataThanOk() throws OperationFormatException {
        Input in = new StubInput("1 + 1");
        new Calculator(in, parser, output).init(false);
        assertThat(parser.getResult(), is("2"));
    }

    @Test(expected = NumberFormatException.class)
    public void whenInputInvalidArabDataThanTryException() throws OperationFormatException {
        Input in = new StubInput("1 + 11");
        new Calculator(in, parser, output).init(false);
        parser.getResult();
    }

    @Test(expected = NumberFormatException.class)
    public void whenInputInvalidArabDataThanTryException2() throws OperationFormatException {
        Input in = new StubInput("0 + 11");
        new Calculator(in, parser, output).init(false);
        parser.getResult();
    }

    @Test(expected = NumberFormatException.class)
    public void whenInputInvalidArabDataThanTryException3() throws OperationFormatException {
        Input in = new StubInput("1 + 11");
        new Calculator(in, parser, output).init(false);
        parser.getResult();
    }

    @Test
    public void whenInputValidRomanDataThanOK() throws OperationFormatException {
        Input in = new StubInput("x + x");
        new Calculator(in, parser, output).init(false);
        assertThat(parser.getResult(), is("XX"));
    }

    @Test(expected = NumberFormatException.class)
    public void whenInputInvalidRomanDataThanTryException() throws OperationFormatException {
        Input in = new StubInput("x + xi");
        new Calculator(in, parser, output).init(false);
        parser.getResult();
    }

    @Test(expected = NumberFormatException.class)
    public void whenInputInvalidRomanDataThanTryException2() throws OperationFormatException {
        Input in = new StubInput("xx + i");
        new Calculator(in, parser, output).init(false);
        parser.getResult();
    }

    @Test
    public void whenMultiplyValidArabDataThanOk() throws OperationFormatException {
        Input in = new StubInput("1 * 5");
        new Calculator(in, parser, output).init(false);
        assertThat(parser.getResult(), is("5"));
    }

    @Test(expected = NumberFormatException.class)
    public void whenMultiplyInvalidArabDataThanTryException() throws OperationFormatException {
        Input in = new StubInput("1 * 11");
        new Calculator(in, parser, output).init(false);
        parser.getResult();
    }

    @Test(expected = NumberFormatException.class)
    public void whenMultiplyInvalidArabDataThanTryException2() throws OperationFormatException {
        Input in = new StubInput("0 * 11");
        new Calculator(in, parser, output).init(false);
        parser.getResult();
    }

    @Test(expected = NumberFormatException.class)
    public void whenMultiplyInvalidArabDataThanTryException3() throws OperationFormatException {
        Input in = new StubInput("1 * 11");
        new Calculator(in, parser, output).init(false);
        parser.getResult();
    }

    @Test
    public void whenMultiplyValidRomanDataThanOK() throws OperationFormatException {
        Input in = new StubInput("x * x");
        new Calculator(in, parser, output).init(false);
        assertThat(parser.getResult(), is("C"));
    }

    @Test
    public void whenMultiplyValidRomanDataThanOK2() throws OperationFormatException {
        Input in = new StubInput("VIII * ii");
        new Calculator(in, parser, output).init(false);
        assertThat(parser.getResult(), is("XVI"));
    }

    @Test(expected = NumberFormatException.class)
    public void whenMultiplyInvalidRomanDataThanTryException() throws OperationFormatException {
        Input in = new StubInput("x * xi");
        new Calculator(in, parser, output).init(false);
        parser.getResult();
    }

    @Test(expected = NumberFormatException.class)
    public void whenMultiplyInvalidRomanDataThanTryException2() throws OperationFormatException {
        Input in = new StubInput("xx * i");
        new Calculator(in, parser, output).init(false);
        parser.getResult();
    }

    @Test
    public void whenSubtractValidArabDataThanOk() throws OperationFormatException {
        Input in = new StubInput("5 - 10");
        new Calculator(in, parser, output).init(false);
        assertThat(parser.getResult(), is("-5"));
    }

    @Test(expected = NumberFormatException.class)
    public void whenSubtractValidDataThanOK3() throws OperationFormatException {
        Input in = new StubInput("0 - 10");
        new Calculator(in, parser, output).init(false);
        parser.getResult();
    }

    @Test
    public void whenSubtractValidDataThanOK4() throws OperationFormatException {
        Input in = new StubInput("1 - 10");
        new Calculator(in, parser, output).init(false);
        assertThat(parser.getResult(), is("-9"));
    }

    @Test
    public void whenSubtractValidDataThanOK() throws OperationFormatException {
        Input in = new StubInput("10 - 6");
        new Calculator(in, parser, output).init(false);
        assertThat(parser.getResult(), is("4"));
    }

    @Test(expected = NumberFormatException.class)
    public void whenSubtractInvalidDataThanTryException3() throws OperationFormatException {
        Input in = new StubInput("11 - 6");
        new Calculator(in, parser, output).init(false);
        parser.getResult();
    }

    @Test(expected = NumberFormatException.class)
    public void whenSubtractValidDataThanOK2() throws OperationFormatException {
        Input in = new StubInput("10 - 0");
        new Calculator(in, parser, output).init(false);
        parser.getResult();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenSubtractValidRomanDataThanOK2() throws OperationFormatException {
        Input in = new StubInput("I - ii");
        new Calculator(in, parser, output).init(false);
        parser.getResult();
    }

    @Test(expected = NumberFormatException.class)
    public void whenSubtractInvalidRomanDataThanTryException() throws OperationFormatException {
        Input in = new StubInput("xi - i");
        new Calculator(in, parser, output).init(false);
        parser.getResult();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenSubtractInvalidRomanDataThanTryException2() throws OperationFormatException {
        Input in = new StubInput("i - i");
        new Calculator(in, parser, output).init(false);
        parser.getResult();
    }

    @Test
    public void whenDivisionValidArabDataThanOK() throws OperationFormatException {
        Input in = new StubInput("10 * 10");
        new Calculator(in, parser, output).init(false);
        assertThat(parser.getResult(), is("100"));
    }

    @Test(expected = NumberFormatException.class)
    public void whenDivisionInvalidArabDataThanTryException() throws OperationFormatException {
        Input in = new StubInput("0 * 10");
        new Calculator(in, parser, output).init(false);
        parser.getResult();
    }

    @Test(expected = NumberFormatException.class)
    public void whenDivisionInvalidArabDataThanTryException2() throws OperationFormatException {
        Input in = new StubInput("11 * 5");
        new Calculator(in, parser, output).init(false);
        parser.getResult();
    }

    @Test
    public void whenDivisionValidArabDataThanOK2() throws OperationFormatException {
        Input in = new StubInput("7 * 1");
        new Calculator(in, parser, output).init(false);
        assertThat(parser.getResult(), is("7"));
    }

    @Test
    public void whenDivisionValidRomanDataThanOK() throws OperationFormatException {
        Input in = new StubInput("x * X");
        new Calculator(in, parser, output).init(false);
        assertThat(parser.getResult(), is("C"));
    }

    @Test
    public void whenDivisionValidRomanDataThanOK2() throws OperationFormatException {
        Input in = new StubInput("i * X");
        new Calculator(in, parser, output).init(false);
        assertThat(parser.getResult(), is("X"));
    }

    @Test
    public void whenDivisionValidRomanDataThanOK3() throws OperationFormatException {
        Input in = new StubInput("vii * vii");
        new Calculator(in, parser, output).init(false);
        assertThat(parser.getResult(), is("XLIX"));
    }

    @Test(expected = NumberFormatException.class)
    public void whenDivisionInvalidRomanDataThanTryException() throws OperationFormatException {
        Input in = new StubInput("xi * v");
        new Calculator(in, parser, output).init(false);
        parser.getResult();
    }

    @Test(expected = NumberFormatException.class)
    public void whenDivisionInvalidRomanDataThanTryException2() throws OperationFormatException {
        Input in = new StubInput("VI * XII");
        new Calculator(in, parser, output).init(false);
        parser.getResult();
    }

    @Test(expected = OperationFormatException.class)
    public void whenDivisionInvalidRomanDataThanTryOperationException() throws OperationFormatException {
        Input in = new StubInput("VI @ X");
        new Calculator(in, parser, output).init(false);
        parser.getResult();
    }

    @Test(expected = OperationFormatException.class)
    public void whenDivisionInvalidArabDataThanTryOperationException() throws OperationFormatException {
        Input in = new StubInput("1 @ 9");
        new Calculator(in, parser, output).init(false);
        parser.getResult();
    }
}