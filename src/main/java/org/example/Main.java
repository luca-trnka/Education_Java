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

            int option = readIntFromUser("Select an option: ", scanner);
            System.out.println("You selected: " + option);

            try {
                if (option == 1) {
                    array = ArrayFunctions.creationOfRandomArray();
                    System.out.println("Random array created;).");
                } else if (option == 2) {
                    array = ArrayFunctions.creationOfArraySetByUser(scanner);
                    if (array.length > 0) {
                        System.out.println("Array created manually:).");
                    } else {
                        System.out.println("Array creation failed:(. Try again.");
                    }
                } else if (option == 3) {
                    if (array != null) {
                        ArrayFunctions.arrayPrinting(array);
                    } else {
                        System.out.println("No array created:(.");
                    }
                } else if (option == 4) {
                    if (array != null) {
                        int newNumber = readIntFromUser("Enter a number to add: ", scanner);
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
                        int numberToRemove = readIntFromUser("Enter a number to remove: ", scanner);
                        boolean onlyFirst = readYesNoFromUser("Remove only the first occurrence? (yes/no): ", scanner);
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
    private static int readIntFromUser(String prompt, Scanner scanner) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a number.");
            }
        }
    }
    private static boolean readYesNoFromUser(String prompt, Scanner scanner) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("yes")) {
                return true;
            } else if (input.equals("no")) {
                return false;
            } else {
                System.out.println("Invalid input, please enter 'yes' or 'no'.");
            }
        }
    }

}
