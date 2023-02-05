package org.example;

// Импорт класса Parameterized и аннотации RunWith
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

// Указали, что тесты будет запускать раннер Parameterized
@RunWith(Parameterized.class)
public class CalculatorTest {
    private final int firstNumber;
    private final int secondNumber;
    private final int expected;
    private final String errorMessage;

    public CalculatorTest(String errorMessage, int firstNumber, int secondNumber, int expected) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.expected = expected;
        this.errorMessage = errorMessage;
    }

    // Добавили аннотацию
    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][] {
                {"Не корректная сумма" ,1, 9, 10},
                {"Не корректная сумма" ,1, 0, 1},
                {"Не корректная сумма" ,1, 0, 2},
        };
    }

    @Test
    public void shouldBeSum() {
        Calculator calculator = new Calculator();
        int actual = calculator.sum(firstNumber, secondNumber);
        Assert.assertEquals(errorMessage ,expected, actual);
    }
}