package org.example;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] array1 = ArrayFunctions.creationOfRandomArray();
        System.out.print("Random creation of array: ");
        ArrayFunctions.arrayPrinting(array1);

        int[] array2 = ArrayFunctions.creationOfArraySetByUser();
        System.out.print("Manual creation of array: ");
        ArrayFunctions.arrayPrinting(array2);

        int [] array3 = {1,2,3,4};
        System.out.print("Printing of chosen array: ");
        ArrayFunctions.arrayPrinting(array3);

        int number = 5;
        int [] array4 = ArrayFunctions.addingNumberToArray(array3, number);
        System.out.print("Adding new number to existing array: ");
        ArrayFunctions.arrayPrinting(array4);
    }
}
