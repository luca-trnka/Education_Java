package org.example;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] array = null;
       // boolean running = true;
        boolean [] running = new boolean[]{true};

        while (running[0]) {
            if (array == null) {
                array = menu1();  //Creates array by welcoming menu (menu1)
            }
            array = menu2(array, running);  //Creates array by additional menu(menu2)

            if (array == null && running[0]) {
                System.out.println("The array has been deleted. Create a new one.");
            }
        }
        scanner.close();
    }

    //creating a welcoming menu for user
    public static int[] menu1() {
        while (true) {
            System.out.print(Menu.menu1());
            int option = readIntFromUser(Menu.chooseOption, scanner);

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
    public static int[] menu2(int[] array, boolean [] running) {

        while (true) {
            System.out.print(Menu.menu2());
            int option2 = readIntFromUser(Menu.chooseOption, scanner);

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
                running[0] = false;
                return null;
            } else {
                System.out.println("Invalid option, try again;).");
            }
        }

    }

    public static int readIntFromUser(String prompt, Scanner scanner) {
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

    public static boolean readYesNoFromUser(String prompt, Scanner scanner) {
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
