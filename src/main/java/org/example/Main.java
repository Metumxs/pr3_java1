package org.example;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        try (Scanner scanner = new Scanner(System.in))
        {
            Calculator calculator = new Calculator();

            System.out.println("=== КАЛЬКУЛЯТОР ===");
            System.out.println("Оберіть операцію:");
            System.out.println("1. Додавання (+)");
            System.out.println("2. Віднімання (-)");
            System.out.println("3. Множення (*)");
            System.out.println("4. Ділення (/)");
            System.out.println("5. Квадратний корінь (√)");
            System.out.print("\nВаш вибір (1-5): ");

            int choice = scanner.nextInt();

            System.out.print("Введіть перше число: ");
            double num1 = scanner.nextDouble();

            double result;

            if (choice == 5) // Квадратний корінь
            {
                result = calculator.squareRoot(num1);
                System.out.println("\nРезультат: √" + num1 + " = " + result);
            }
            else if (choice >= 1 && choice <= 4)
            {
                System.out.print("Введіть друге число: ");
                double num2 = scanner.nextDouble();

                switch (choice)
                {
                    case 1:
                        result = calculator.add(num1, num2);
                        System.out.println("\nРезультат: " + num1 + " + " + num2 + " = " + result);
                        break;
                    case 2:
                        result = calculator.subtract(num1, num2);
                        System.out.println("\nРезультат: " + num1 + " - " + num2 + " = " + result);
                        break;
                    case 3:
                        result = calculator.multiply(num1, num2);
                        System.out.println("\nРезультат: " + num1 + " * " + num2 + " = " + result);
                        break;
                    case 4:
                        result = calculator.divide(num1, num2);
                        System.out.println("\nРезультат: " + num1 + " / " + num2 + " = " + result);
                        break;
                }
            }
            else
            {
                System.out.println("Невірний вибір. Оберіть число від 1 до 5.");
            }

        } catch (ArithmeticException | InvalidInputException e)
        {
            System.err.println("Помилка обчислення: " + e.getMessage());
        } catch (InputMismatchException e)
        {
            System.err.println("Помилка вводу: будь ласка, вводьте тільки числа.");
        } catch (Exception e)
        {
            System.err.println("Сталася непередбачувана помилка: " + e.getMessage());
        } finally
        {
            System.out.println("\n--- Завершення обробки запиту ---");
        }
    }
}