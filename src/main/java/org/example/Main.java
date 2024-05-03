package org.example;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array1 = ArrayFunctions.creationOfRandomArray();
        ArrayFunctions.arrayPrinting(array1);

        int[] array2 = ArrayFunctions.creationOfArraySetByUser();
        ArrayFunctions.arrayPrinting(array2);

        int [] array3 = {1,2,3,4};
        ArrayFunctions.arrayPrinting(array3);

        int number = 5;
        int [] array4 = ArrayFunctions.addingNumberToArray(array3, number);
        ArrayFunctions.arrayPrinting(array4);
    }
}