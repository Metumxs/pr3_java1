package org.example;


// Власний клас виключення для обробки невірних вхідних даних.
public class InvalidInputException extends Exception
{
    public InvalidInputException(String message)
    {
        super(message);
    }
}
