package org.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
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
        Main.menu1();

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
        Main.menu1();

        //verifying the output
        String expectedOutput = Menu.menu1() + Menu.chooseOption +
                "Random array created:).\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testMenu1_WrongOptionCorrectionExit() {
        //preparing mock input
        String input = "3\n2\n7\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //executing the method
        Main.main(new String[0]);

        //verifying the output
        String expectedOutput = Menu.menu1() + Menu.chooseOption +
                "Invalid option, please enter 1 or 2.\r\n" +
                Menu.menu1() + Menu.chooseOption +
                "Random array created:).\r\n" +
                Menu.menu2() +
                Menu.chooseOption +
                "Exiting program. Bye:(\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }


}
