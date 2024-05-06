package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = null;
        boolean running = true;

        while (running) {  //creating a menu for the user
            System.out.println("Let's play with arrays!");
            System.out.println("1. Create random array");
            System.out.println("2. Create array manually");
            System.out.println("3. Print the array");
            System.out.println("4. Add new number to the array");
            System.out.println("5. Find the largest number from the array");
            System.out.println("6. Find the smallest number from the array");
            System.out.println("7. Delete number from the array");
            System.out.println("8. Remove the array");
            System.out.println("9. Exit the program");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();
        }
    }
}
