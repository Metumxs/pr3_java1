package org.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest
{
    private Calculator calculator;

    @BeforeEach
    void setUp()
    {
        // Ініціалізуємо новий екземпляр калькулятора перед кожним тестом
        calculator = new Calculator();
    }

    @Test
    void testAdd()
    {
        assertEquals(5.0, calculator.add(2.0, 3.0), "2 + 3 повинно дорівнювати 5");
    }

    @Test
    void testSubtract()
    {
        assertEquals(-1.0, calculator.subtract(2.0, 3.0), "2 - 3 повинно дорівнювати -1");
    }

    @Test
    void testMultiply()
    {
        assertEquals(6.0, calculator.multiply(2.0, 3.0), "2 * 3 повинно дорівнювати 6");
    }

    @Test
    void testDivide()
    {
        assertEquals(2.0, calculator.divide(6.0, 3.0), "6 / 3 повинно дорівнювати 2");
    }

    @Test
    void testDivideByZero()
    {
        // Перевіряємо, що при діленні на нуль буде викинуто ArithmeticException
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(1.0, 0.0);
        });
    }

    @Test
    void testSquareRoot() throws InvalidInputException
    {
        assertEquals(5.0, calculator.squareRoot(25.0), "Корінь з 25 повинен дорівнювати 5");
    }

    @Test
    void testSquareRootOfNegativeNumber()
    {
        // Перевіряємо, що при спробі взяти корінь з від'ємного числа
        // буде викинуто наше власне виключення InvalidInputException
        Exception exception = assertThrows(InvalidInputException.class, () -> {
            calculator.squareRoot(-25.0);
        });
    }
}