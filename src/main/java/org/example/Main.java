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
            System.out.println("You selected: " + option);

            try {
                if (option == 1) {
                    array = ArrayFunctions.creationOfRandomArray();
                    System.out.println("Random array created;).");
                } else if (option == 2) {
                    array = ArrayFunctions.creationOfArraySetByUser();
                    System.out.println("Array created manually;).");
                } else if (option == 3) {
                    if (array != null) {
                        ArrayFunctions.arrayPrinting(array);
                    } else {
                        System.out.println("No array created:(.");
                    }
                } else if (option == 4) {
                    if (array != null) {
                        System.out.print("Enter a number to add: ");
                        int newNumber = scanner.nextInt();
                        array = ArrayFunctions.addingNumberToArray(array, newNumber);
                        System.out.println("Number added;).");
                    } else {
                        System.out.println("No array exists. Create some array first;).");
                    }
                } else if (option == 5) {
                    if (array != null) {
                        System.out.println("The largest number is: " + ArrayFunctions.findingMaxNumber(array));
                    } else {
                        System.out.println("No array exists:(.");
                    }
                } else if (option == 6) {
                    if (array != null) {
                        System.out.println("The smallest number is: " + ArrayFunctions.findingMinNumber(array));
                    } else {
                        System.out.println("No array exists:(.");
                    }
                } else if (option == 7) {
                    if (array != null) {
                        System.out.print("Enter a number to remove: ");
                        int numberToRemove = scanner.nextInt();
                        System.out.print("Remove only the first occurrence? (yes/no): ");
                        boolean onlyFirst = scanner.next().equalsIgnoreCase("yes");
                        array = ArrayFunctions.deleteNumberFromArray(array, numberToRemove, onlyFirst);
                        System.out.println("Number removed;).");
                    } else {
                        System.out.println("No array exists:(. Create an array first;).");
                    }
                } else if (option == 8) {
                    array = ArrayFunctions.removeArray(array);
                    System.out.println("Array deleted;).");
                } else if (option == 9) {
                    running = false;
                    System.out.println("Exiting program. Bye:(");
                } else {
                    System.out.println("Invalid option, try again;).");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a number;).");
            }
        }
        scanner.close();
    }

}
