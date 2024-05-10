package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
        int[] emptyArray = new int[0];
        String maxNumber = ArrayFunctions.findingMaxNumber(array);
        String minNumber = ArrayFunctions.findingMinNumber(array);
        String noNumber = ArrayFunctions.findingMaxNumber(emptyArray);
        String noNumber2 = ArrayFunctions.findingMinNumber(emptyArray);

        assertEquals("The largest number is: 5.", maxNumber);
        assertEquals("The smallest number is: 1.", minNumber);
        assertEquals("There are no numbers.", noNumber);
        assertEquals("There are no numbers.", noNumber2);
    }

    @Test
    public void testDeleteNumberFromArray() {
        int[] arrayA = {1, 2, 3, 4, 5, 2};
        int[] arrayB = new int[0];
        int[] newArray = ArrayFunctions.deleteNumberFromArray(arrayA, 2, true);
        int[] newArray2 = ArrayFunctions.deleteNumberFromArray(arrayA, 2, false);
        int[] newArray3 = ArrayFunctions.deleteNumberFromArray(arrayA, 7, true);
        int[] newArray4 = ArrayFunctions.deleteNumberFromArray(arrayB, 7, true);

        assertNotNull(newArray);
        assertArrayEquals(new int[]{1, 3, 4, 5, 2}, newArray);
        assertArrayEquals(new int[]{1, 3, 4, 5}, newArray2);
        assertArrayEquals(arrayA, newArray3);
        assertArrayEquals(arrayB, newArray4);
    }

    @Test
    public void testRemoveArray() {
        int[] array = {1, 2, 3, 4, 5};
        int[] removedArray = ArrayFunctions.removeArray(array);

        assertNull(removedArray);
    }

}