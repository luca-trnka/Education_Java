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
        String expectedOutput = "Hi! Let's play with arrays!\r\n" +
                "At first, please choose how you want to create your array:\r\n" +
                "1. Create array manually\r\n" +
                "2. Create random array\r\n" +
                "Choose an option: " +
                "Enter numbers separated by commas (f.e. \"1,2,3\"): \r\n" +
                "Array created manually:).\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }

}
