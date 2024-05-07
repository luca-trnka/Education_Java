package org.example;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;


public class ArrayFunctionsTest {

    @Test
    public void testCreationOfRandomArray() {
        int[] array = ArrayFunctions.creationOfRandomArray();

        assertNotNull(array);
        assertTrue(array.length > 0);
    }

    @Test
    public void testCreationOfArraySetByUser() {
        //ideal format of user input
        String correctInput = "1, 2, 3, 4, 5";
        String incorrectInput = "hello";
        int[] array = ArrayFunctions.creationOfArraySetByUser(correctInput);
        int[] array2 = ArrayFunctions.creationOfArraySetByUser(incorrectInput);

        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
        assertEquals(0, array2.length);
    }

    @Test
    public void testArrayPrinting() {
        //capturing the output that would normally be printed to the console
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        int[] array = {1, 2, 3, 4, 5};
        //printing array to output stream(System.out), which is now redirected to outContent
        ArrayFunctions.arrayPrinting(array);

        assertEquals("1 2 3 4 5 \r\n", outContent.toString());
        System.setOut(System.out);
    }

    @Test
    public void testAddingNumberToArray() {
        int[] array = {1, 2, 3, 4, 5};
        int newNumber = 6;
        int[] newArray = ArrayFunctions.addingNumberToArray(array, newNumber);

        assertNotNull(newArray);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, newArray);
    }

    @Test
    public void testFindingMinandMaxNumber() {
        int[] array = {1, 3, 5, 2, 4};
        int maxNumber = ArrayFunctions.findingMaxNumber(array);
        int minNumber = ArrayFunctions.findingMinNumber(array);

        assertEquals(5, maxNumber);
        assertEquals(1, minNumber);
    }

    @Test
    public void testDeleteNumberFromArray() {
        int[] array = {1, 2, 3, 4, 5, 2};
        int[] newArray = ArrayFunctions.deleteNumberFromArray(array, 2, true);
        int[] newArray2 = ArrayFunctions.deleteNumberFromArray(array, 2, false);
        int[] newArray3 = ArrayFunctions.deleteNumberFromArray(array, 7, true);

        assertNotNull(newArray);
        assertArrayEquals(new int[]{1, 3, 4, 5, 2}, newArray);
        assertArrayEquals(new int[]{1, 3, 4, 5}, newArray2);
        assertArrayEquals(array, newArray3);
    }

    @Test
    public void testRemoveArray() {
        int[] array = {1, 2, 3, 4, 5};
        int[] removedArray = ArrayFunctions.removeArray(array);

        assertNull(removedArray);
    }

}