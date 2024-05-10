package org.example;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainTest {
    private ByteArrayOutputStream outContent;
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    public void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.setIn(originalIn);
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void testMenu1_CreateArrayManually() {
        //preparing mock input
        String input = "1\n1,2,3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //executing the method
        Main.menu1(new Scanner(System.in));

        //verifying the output
        String expectedOutput = Menu.menu1() + Menu.chooseOption +
                "Enter numbers separated by commas (f.e. \"1,2,3\"): \r\n" +
                "Array created manually:).\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testMenu1_CreateRandomArray() {
        //preparing mock input
        String input = "2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //executing the method
        Main.menu1(new Scanner(System.in));

        //verifying the output
        String expectedOutput = Menu.menu1() + Menu.chooseOption + "Random array created:).\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testMenu1_WrongOption_Correction_Exit() {
        //preparing mock input
        String input = "3\n2\n7\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //executing the method
        Main.main(new String[0]);

        //verifying the output
        String expectedOutput = Menu.menu1() + Menu.chooseOption + "Invalid option, please enter 1 or 2.\r\n" +
                Menu.menu1() + Menu.chooseOption + "Random array created:).\r\n" +
                Menu.menu2() + Menu.chooseOption + "Exiting program. Bye:(\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testMenu2_PrintArray_Exit() {
        //preparing mock input
        String input = "1\n7\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int[] array = new int[]{1, 2, 3};

        //executing the method
        Main.menu2(array, new boolean[]{true}, new Scanner(System.in));

        //verifying the output
        String expectedOutput =
                Menu.menu2() + Menu.chooseOption + "1 2 3 \r\n" +
                        Menu.menu2() + Menu.chooseOption + "Exiting program. Bye:(\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testMenu2_AddNumberToArray_Exit() {
        //preparing mock input
        String input = "2\n501\n7\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int[] array = new int[]{1, 2, 3};

        //executing the method
        Main.menu2(array, new boolean[]{true}, new Scanner(System.in));

        //verifying the output
        String expectedOutput =
                Menu.menu2() + Menu.chooseOption + "Enter a number to add: " + "Number added;).\r\n" +
                        Menu.menu2() + Menu.chooseOption + "Exiting program. Bye:(\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testMenu2_FindMaxNumber() {
        String input = "3\n7\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int[] array = new int[]{1, 2, 3};

        // Executing the method
        Main.menu2(array, new boolean[]{true}, new Scanner(System.in));

        String expectedOutput = Menu.menu2() + Menu.chooseOption +
                "The largest number is: 3\r\n" +
                Menu.menu2() + Menu.chooseOption + "Exiting program. Bye:(\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testMenu2_FindMinNumber() {
        String input = "4\n7\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int[] array = new int[]{1, 2, 3};

        // Executing the method
        Main.menu2(array, new boolean[]{true}, new Scanner(System.in));

        String expectedOutput = Menu.menu2() + Menu.chooseOption +
                "The smallest number is: 1\r\n" +
                Menu.menu2() + Menu.chooseOption + "Exiting program. Bye:(\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testMenu2_RemoveNumberFromArray() {
        String input = "5\n2\nyes\n7\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int[] array = new int[]{1, 2, 3, 2};

        // Executing the method
        Main.menu2(array, new boolean[]{true}, new Scanner(System.in));

        String expectedOutput = Menu.menu2() + Menu.chooseOption +
                "Enter a number to remove: " + "Remove only the first occurrence? (yes/no): " + "Number removed;).\r\n" +
                Menu.menu2() + Menu.chooseOption + "Exiting program. Bye:(\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testMenu2_RemoveNumberFromArray2() {
        String input = "5\n2\n7\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int[] array = new int[]{1, 2, 3};

        // Executing the method
        Main.menu2(array, new boolean[]{true}, new Scanner(System.in));

        String expectedOutput = Menu.menu2() + Menu.chooseOption +
                "Enter a number to remove: " + "Number removed;).\r\n" +
                Menu.menu2() + Menu.chooseOption + "Exiting program. Bye:(\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }


    @Test
    public void testMenu2_RemoveNumberFromArray3() {
        String input = "5\n7\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int[] array = new int[0];

        // Executing the method
        Main.menu2(array, new boolean[]{true}, new Scanner(System.in));

        String expectedOutput = Menu.menu2() + Menu.chooseOption +
                "There is nothing to remove;).\r\n" +
                Menu.menu2() + Menu.chooseOption + "Exiting program. Bye:(\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testMenu2_RemoveArray() {
        String input = "6\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int[] array = new int[]{1, 2, 3};

        // Executing the method
        Main.menu2(array, new boolean[]{true}, new Scanner(System.in));

        String expectedOutput = Menu.menu2() + Menu.chooseOption +
                "Array deleted;).\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }



    @Test
    public void testMenu2_ExitProgram() {
        String input = "7\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int[] array = new int[]{1, 2, 3};

        // Executing the method
        boolean[] running = new boolean[]{true};
        Main.menu2(array, running, new Scanner(System.in));

        String expectedOutput = Menu.menu2() + Menu.chooseOption +
                "Exiting program. Bye:(\r\n";
        assertEquals(expectedOutput, outContent.toString());
        assertFalse(running[0]);
    }

    @Test
    public void testReadIntFromUser_ValidInput() {
        String input = "5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int result = Main.readIntFromUser("Enter a number: ", new Scanner(System.in));
        assertEquals(5, result);
    }

    @Test
    public void testReadIntFromUser_InvalidInput() {
        String input = "invalid\n5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int result = Main.readIntFromUser("Enter a number: ", new Scanner(System.in));
        assertEquals(5, result);

        String expectedOutput = "Enter a number: Invalid input, please enter a number.\r\nEnter a number: ";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testReadYesNoFromUser_YesInput() {
        String input = "yes\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        boolean result = Main.readYesNoFromUser("Do you agree? (yes/no): ", new Scanner(System.in));
        assertTrue(result);
    }

    @Test
    public void testReadYesNoFromUser_NoInput() {
        String input = "no\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        boolean result = Main.readYesNoFromUser("Do you agree? (yes/no): ", new Scanner(System.in));
        assertFalse(result);
    }

    @Test
    public void testReadYesNoFromUser_InvalidInput() {
        String input = "maybe\nyes\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        boolean result = Main.readYesNoFromUser("Do you agree? (yes/no): ", new Scanner(System.in));
        assertTrue(result);

        String expectedOutput = "Do you agree? (yes/no): Invalid input, please enter 'yes' or 'no'.\r\nDo you agree? (yes/no): ";
        assertEquals(expectedOutput, outContent.toString());
    }

}
