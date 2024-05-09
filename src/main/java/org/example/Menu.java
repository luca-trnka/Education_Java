package org.example;

public class Menu {

    public static String[] menu1Title = new String[]{
            "Hi! Let's play with arrays!",
            "At first, please choose how you want to create your array:"
    };

    public static String[] menu1Options = new String[]{
            "1. Create array manually",
            "2. Create random array"
    };

    public static String menu2Title = "Now what?";

    public static String[] menu2Options = new String[]{
            "1. Print the array",
            "2. Add new number to the array",
            "3. Find the largest number from the array",
            "4. Find the smallest number from the array",
            "5. Delete number from the array",
            "6. Remove the array",
            "7. Exit the program"
    };

    public static String chooseOption = "Choose an option: ";

    public static String menu1() {
        StringBuilder sb = new StringBuilder();
        for (String t : menu1Title) {
            sb.append(t);
            sb.append(System.lineSeparator());
        }
        for (String t : menu1Options) {
            sb.append(t);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static String menu2() {
        StringBuilder sb = new StringBuilder();
        sb.append(menu2Title);
        sb.append(System.lineSeparator());

        for (String t : menu2Options) {
            sb.append(t);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

}
