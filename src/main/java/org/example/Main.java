package org.example;

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

        int number = 77;
        int [] array4 = ArrayFunctions.addingNumberToArray(array3, number);
        System.out.print("Adding new number to existing array: ");
        ArrayFunctions.arrayPrinting(array4);

        int maxNumber = ArrayFunctions.findingMaxNumber(array4);
        System.out.println("The Largest number from previous array is: " + maxNumber);

        int minNumber = ArrayFunctions.findingMinNumber(array4);
        System.out.println("The Smallest number from previous array is: " + minNumber);

        int [] array5 = ArrayFunctions.deleteNumberFromArray(array4, 8, false);
        System.out.print("Array after deletion of given number: ");
        ArrayFunctions.arrayPrinting(array5);

        int [] array6 = ArrayFunctions.removeArray(array5);
        System.out.println("Array after clearing: " + (array6 == null ? "removed" : "not removed properly"));
    }
}
