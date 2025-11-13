package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        // Головний цикл програми
        while (true)
        {
            try
            {
                double result;

                System.out.println("\n=== КАЛЬКУЛЯТОР ===");
                System.out.println("Оберіть операцію:");
                System.out.println("1. Додавання (+)");
                System.out.println("2. Віднімання (-)");
                System.out.println("3. Множення (*)");
                System.out.println("4. Ділення (/)");
                System.out.println("5. Квадратний корінь (√)");
                System.out.println("\n0. Вийти"); // ДОДАНО
                System.out.print("\nВаш вибір (0-5): ");

                int choiceOperation = scanner.nextInt();
                scanner.nextLine();

                // Перевірка на вихід
                if (choiceOperation == 0)
                {
                    break;
                }

                if (choiceOperation == 5) // Квадратний корінь
                {
                    System.out.print("Введіть число: ");
                    double num1 = scanner.nextDouble();
                    scanner.nextLine();

                    result = Calculator.squareRoot(num1);
                    printResult(num1, result, "√");
                }
                else if (choiceOperation >= 1 && choiceOperation <= 4)
                {
                    System.out.print("Введіть перше число: ");
                    double num1 = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Введіть друге число: ");
                    double num2 = scanner.nextDouble();
                    scanner.nextLine();

                    switch (choiceOperation)
                    {
                        case 1: // Додавання
                            result = Calculator.add(num1, num2);
                            printResult(num1, num2, result, "+");
                            break;
                        case 2: // Віднімання
                            result = Calculator.subtract(num1, num2);
                            printResult(num1, num2, result, "-");
                            break;
                        case 3: // Множення
                            result = Calculator.multiply(num1, num2);
                            printResult(num1, num2, result, "*");
                            break;
                        case 4: // Ділення
                            result = Calculator.divide(num1, num2);
                            printResult(num1, num2, result, "/");
                            break;
                    }
                }
                else
                {
                    System.out.println("Невірний вибір. Оберіть число від 0 до 5.");
                }

            }
            catch (ArithmeticException | InvalidInputException e)
            {
                System.err.println(e.getMessage());
            }
            catch (InputMismatchException e)
            {
                System.err.println("Помилка вводу: будь ласка, вводьте тільки числа.");

                // Очищення буфера сканера від помилкового вводу, щоб уникнути нескінченного циклу
                scanner.nextLine();
            }
            catch (Exception e)
            {
                System.err.println("Сталася непередбачувана помилка: " + e.getMessage());
            }
            finally
            {
                System.out.println("\n----------------------------------");
                System.out.println("Натисніть Enter для продовження...");
                System.out.println("----------------------------------");

                scanner.nextLine();
            }
        }

        scanner.close();
        System.out.println("\nРОБОТУ КАЛЬКУЛЯТОРА ЗАВЕРШЕНО");
    }

    private static void printResult(double num1, double num2, double result, String operator)
    {
        System.out.println("\n" + num1 + " " + operator + " " + num2 + " = " + result);
        System.out.println("РЕЗУЛЬТАТ: " + result);
    }

    private static void printResult(double num1, double result, String Operator)
    {
        System.out.println("\n" + Operator + num1 + " = " + result);
        System.out.println("РЕЗУЛЬТАТ: " + result);
    }
}