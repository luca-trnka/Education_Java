package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = null;
        boolean running = true;

        //creating a menu for the user
        System.out.println("Hi! Let's play with arrays!");
        System.out.println("At first, please choose how you want to create your array:");
        System.out.println("1. Create array manually");
        System.out.println("2. Create random array");
        int option = readIntFromUser("You've selected: ", scanner);
        while (running) {
            if (option == 1) {
                array = ArrayFunctions.creationOfArraySetByUser(scanner);
                System.out.println("Array created manually:).");
                break;
            } else if (option == 2) {
                array = ArrayFunctions.creationOfRandomArray();
                System.out.println("Random array created:).");
                break;
            } else {
                System.out.println("Invalid option, please enter 1 or 2.");
            }
        }

        while (running) {
            System.out.println("Now what?");
            System.out.println("1. Print the array");
            System.out.println("2. Add new number to the array");
            System.out.println("3. Find the largest number from the array");
            System.out.println("4. Find the smallest number from the array");
            System.out.println("5. Delete number from the array");
            System.out.println("6. Remove the array");
            System.out.println("7. Exit the program");
            int option2 = readIntFromUser("You've selected: ", scanner);

            try {
                if (option2 == 1) {
                    if (array != null) {
                        ArrayFunctions.arrayPrinting(array);
                    } else {
                        System.out.println("No array created:(.");
                    }
                } else if (option2 == 2) {
                    if (array != null) {
                        int newNumber = readIntFromUser("Enter a number to add: ", scanner);
                        array = ArrayFunctions.addingNumberToArray(array, newNumber);
                        System.out.println("Number added;).");
                    } else {
                        System.out.println("No array exists. Create some array first;).");
                    }
                } else if (option2 == 3) {
                    if (array != null) {
                        System.out.println("The largest number is: " + ArrayFunctions.findingMaxNumber(array));
                    } else {
                        System.out.println("No array exists:(.");
                    }
                } else if (option2 == 4) {
                    if (array != null) {
                        System.out.println("The smallest number is: " + ArrayFunctions.findingMinNumber(array));
                    } else {
                        System.out.println("No array exists:(.");
                    }
                } else if (option2 == 5) {
                    if (array != null) {
                        int numberToRemove = readIntFromUser("Enter a number to remove: ", scanner);
                        boolean onlyFirst = readYesNoFromUser("Remove only the first occurrence? (yes/no): ", scanner);
                        array = ArrayFunctions.deleteNumberFromArray(array, numberToRemove, onlyFirst);
                        System.out.println("Number removed;).");
                    } else {
                        System.out.println("No array exists:(. Create an array first;).");
                    }
                } else if (option2 == 6) {
                    array = ArrayFunctions.removeArray(array);
                    System.out.println("Array deleted;).");
                } else if (option2 == 7) {
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
