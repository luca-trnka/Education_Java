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

    //Creation of array with length and numbers set by user inputs
    public static int[] creationOfArraySetByUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of array: ");
        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.print("Enter the number on position " + (i) + ": ");
            array[i] = scanner.nextInt();
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

}
