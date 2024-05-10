package org.example;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = null;
        // boolean running = true;
        boolean[] running = new boolean[]{true};

        while (running[0]) {
            if (array == null) {
                array = menu1(scanner);  //Creates array by welcoming menu (menu1)
            }
            array = menu2(array, running, scanner);  //Creates array by additional menu(menu2)

            if (array == null && running[0]) {
                System.out.println("There is no array left. Create a new one.");
            }
        }
        scanner.close();
    }

    //creating a welcoming menu for user
    public static int[] menu1(Scanner scanner) {
        while (true) {
            System.out.print(Menu.menu1());
            int option = readIntFromUser(Menu.chooseOption, scanner);

            switch (option) {
                case 1:
                    while (true) {
                        System.out.println("Enter numbers separated by commas (f.e. \"1,2,3\"): ");
                        String input = scanner.nextLine();  //Reads whole row of String
                        int[] array = ArrayFunctions.creationOfArraySetByUser(input);
                        if (array.length > 0) {
                            System.out.println("Array created manually:).");
                            return array;
                        } else {
                            System.out.println("Try it again;)!");
                            break;
                        }
                    }

                case 2:
                    System.out.println("Random array created:).");
                    return ArrayFunctions.creationOfRandomArray();
                default:
                    System.out.println("Invalid option, please enter 1 or 2.");
            }
        }
    }

    //creating an additional menu for user
    public static int[] menu2(int[] array, boolean[] running, Scanner scanner) {

        while (true) {
            System.out.print(Menu.menu2());
            int option2 = readIntFromUser(Menu.chooseOption, scanner);

            switch (option2) {
                case 1:
                    ArrayFunctions.arrayPrinting(array);
                    break;
                case 2:
                    int newNumber = readIntFromUser("Enter a number to add: ", scanner);
                    array = ArrayFunctions.addingNumberToArray(array, newNumber);
                    System.out.println("Number added;).");
                    break;
                case 3:
                    System.out.println(ArrayFunctions.findingMaxNumber(array));
                    break;
                case 4:
                    System.out.println(ArrayFunctions.findingMinNumber(array));
                    break;
                case 5:
                    int lengthOfArray = array.length;
                    if (lengthOfArray > 0) {
                        int numberToRemove = readIntFromUser("Enter a number to remove: ", scanner);
                        int count = ArrayFunctions.findOccurencyOfNumber(array, numberToRemove);
                        boolean onlyFirst = false;
                        if (count > 1) {
                            onlyFirst = readYesNoFromUser("Remove only the first occurrence? (yes/no): ", scanner);
                        }
                        array = ArrayFunctions.deleteNumberFromArray2(array, numberToRemove, onlyFirst, count);
                        int newLengthOFArray = array.length;
                        if (lengthOfArray > newLengthOFArray) {
                            System.out.println("Number removed;).");
                        } else {
                            System.out.println("There is nothing to remove;).");
                        }
                    } else {
                        System.out.println("There is nothing to remove;).");
                    }
                    break;
                case 6:
                    array = ArrayFunctions.removeArray(array);
                    System.out.println("Array deleted;).");
                    return array;
                case 7:
                    System.out.println("Exiting program. Bye:(");
                    running[0] = false;
                    return null;
                default:
                    System.out.println("Invalid option, try again;).");
                    break;
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
