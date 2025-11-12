package org.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest
{
    @Test
    void testAdd()
    {
        assertEquals(5.0, Calculator.add(2.0, 3.0), "2 + 3 повинно дорівнювати 5");
    }

    @Test
    void testSubtract()
    {
        assertEquals(-1.0, Calculator.subtract(2.0, 3.0), "2 - 3 повинно дорівнювати -1");
    }

    @Test
    void testMultiply()
    {
        assertEquals(6.0, Calculator.multiply(2.0, 3.0), "2 * 3 повинно дорівнювати 6");
    }

    @Test
    void testDivide()
    {
        assertEquals(2.0, Calculator.divide(6.0, 3.0), "6 / 3 повинно дорівнювати 2");
    }

    @Test
    void testDivideByZero()
    {
        // Перевіряємо, що при діленні на нуль буде викинуто ArithmeticException
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            Calculator.divide(1.0, 0.0);
        });
    }

    @Test
    void testSquareRoot() throws InvalidInputException
    {
        assertEquals(5.0, Calculator.squareRoot(25.0), "Корінь з 25 повинен дорівнювати 5");
    }

    @Test
    void testSquareRootOfNegativeNumber()
    {
        // Перевіряємо, що при спробі взяти корінь з від'ємного числа
        // буде викинуто наше власне виключення InvalidInputException
        Exception exception = assertThrows(InvalidInputException.class, () -> {
            Calculator.squareRoot(-25.0);
        });
    }
}