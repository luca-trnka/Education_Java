package org.example;

import java.util.Random;
import java.util.Scanner;

public class ArrayFunctions {


    //Creation of random array with random length (1-10) and random ints with values (-100 -> +100)
    public static int[] creationOfRandomArray() {
        Random random = new Random();
        int max_length_size = 10;
        int max_int_size = 200;
        int length = random.nextInt(max_length_size) + 1;
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(max_int_size) - 100;
        }
        return array;
    }

    //Creation of array with numbers set by user inputs
    public static int[] creationOfArraySetByUser(String input) {
        String[] arrayOfStringNumbers = input.split(",");  //Splits whole String into array of StringNumbers
        int[] array = new int[arrayOfStringNumbers.length];

        for (int i = 0; i < arrayOfStringNumbers.length; i++) {
            try {
                array[i] = Integer.parseInt(arrayOfStringNumbers[i].trim());  //Remakes every StringNumber to Integer
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: '" + arrayOfStringNumbers[i] + "' is not a valid integer.");
                array = new int[0];
            }
        }
        return array;
    }

    //Printing of chosen array
    public static void arrayPrinting(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    //Adding new number to existing array
    public static int[] addingNumberToArray(int[] array, int number) {
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[array.length] = number;
        return newArray;
    }

    //Looking for the max number from given array
    public static int findingMaxNumber(int[] array) {
        int maxNumber = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxNumber) {
                maxNumber = array[i];
            }
        }
        return maxNumber;
    }

    //Looking for the min number from given array
    public static int findingMinNumber(int[] array) {
        int minNumber = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < minNumber) {
                minNumber = array[i];
            }
        }
        return minNumber;
    }

    //Delete given number from array
    public static int[] deleteNumberFromArray(int[] array, int number, boolean onlyFirst) {
        int count = 0;
        for (int i = 0; i <array.length; i++) { //Looking for amount of the given number in given array
            if (array[i] == number) {
                count++;
                if (onlyFirst) {
                    break; //If it should delete only first matching number, it should stop after it will find it
                }
            }
        }
        if (count == 0) { //If given number is not there, it will return original array
            return array;
        }
        int remainToDelete; //Setting how many times it will delete the number
        if (onlyFirst) {
            remainToDelete = 1;
        } else {
            remainToDelete = count;
        }
        //Creation of new array with new length (depends on the count of deletions)
        int[] newArray = new int[array.length - remainToDelete];
        int newIndex = 0;
        int alreadyDeleted = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != number || alreadyDeleted >= remainToDelete) {
                newArray[newIndex] = array[i];
                newIndex++;
            } else {
                alreadyDeleted++; // Increment the count of removed occurrences.
            }
        }
        return newArray;
    }

    public static int[] removeArray(int[] array) {
        return null;
    }

}
