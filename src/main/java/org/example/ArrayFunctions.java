package org.example;

import java.util.Random;

public class ArrayFunctions {

    //Creation of random array with random length (1-10) and random ints with values (1-100)
    public static int[] creationOfRandomArray() {
        Random random = new Random();
        int max_length_size = 10;
        int max_int_size = 100;
        int length = random.nextInt(max_length_size) + 1;
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(max_int_size) + 1;
        }
        return array;
    }


}
