package org.example;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] array = null;
        boolean running = true;

        while (running) {
            if (array == null) {
                array = menu1();  //Creates array by welcoming menu (menu1)
            }
            array = menu2(array);  // Creates array by additional menu(menu2)

            if (array == null) {
                System.out.println("The array has been deleted. Create a new one.");
            }
        }
        scanner.close();
    }

    //creating a welcoming menu for user
    private static int[] menu1() {
        while (true) {
            System.out.println("Hi! Let's play with arrays!");
            System.out.println("At first, please choose how you want to create your array:");
            System.out.println("1. Create array manually");
            System.out.println("2. Create random array");
            int option = readIntFromUser("Choose an option: ", scanner);

            if (option == 1) {
                while (true) {
                    System.out.println("Enter numbers separated by commas (f.e. \"1,2,3\"): ");
                    String input = scanner.nextLine();  //Reads whole row of String
                    int [] array = ArrayFunctions.creationOfArraySetByUser(input);
                    if (array.length > 0) {
                        System.out.println("Array created manually:).");
                        return array;
                    } else {
                        System.out.println("Try it again;)!");
                    }
                }

            } else if (option == 2) {
                System.out.println("Random array created:).");
                return ArrayFunctions.creationOfRandomArray();
            } else {
                System.out.println("Invalid option, please enter 1 or 2.");
            }
        }
    }

    //creating an additional menu for user
    private static int[] menu2(int[] array) {
        while (true) {
            System.out.println("Now what?");
            System.out.println("1. Print the array");
            System.out.println("2. Add new number to the array");
            System.out.println("3. Find the largest number from the array");
            System.out.println("4. Find the smallest number from the array");
            System.out.println("5. Delete number from the array");
            System.out.println("6. Remove the array");
            System.out.println("7. Exit the program");
            int option2 = readIntFromUser("Choose an option: ", scanner);

            if (option2 == 1) {
                ArrayFunctions.arrayPrinting(array);
            } else if (option2 == 2) {
                int newNumber = readIntFromUser("Enter a number to add: ", scanner);
                array = ArrayFunctions.addingNumberToArray(array, newNumber);
                System.out.println("Number added;).");
            } else if (option2 == 3) {
                System.out.println("The largest number is: " + ArrayFunctions.findingMaxNumber(array));
            } else if (option2 == 4) {
                System.out.println("The smallest number is: " + ArrayFunctions.findingMinNumber(array));
            } else if (option2 == 5) {
                int numberToRemove = readIntFromUser("Enter a number to remove: ", scanner);
                boolean onlyFirst = readYesNoFromUser("Remove only the first occurrence? (yes/no): ", scanner);
                array = ArrayFunctions.deleteNumberFromArray(array, numberToRemove, onlyFirst);
                System.out.println("Number removed;).");
            } else if (option2 == 6) {
                array = ArrayFunctions.removeArray(array);
                System.out.println("Array deleted;).");
                return array;
            } else if (option2 == 7) {
                System.out.println("Exiting program. Bye:(");
                return array;
            } else {
                System.out.println("Invalid option, try again;).");
            }
        }

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
