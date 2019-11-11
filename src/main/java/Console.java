

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Console {
    public static void printWelcome(){
        println("\n" +
                "**************************************************\n" +
                "***           Welcome and Bienvenue            ***\n" +
                "***                    to                      ***\n" +
                "***          ZipCo Inventory Manager           ***\n" +
                "**************************************************\n\n");
    }

    public static void printMenu(String[] choices) {
        for (int i = 1; i <= choices.length; i++) {
            println(String.format("%d. %s",i, choices[i-1]));
        }
    }

    public static void viewFields(Object classObject) {
        println(classObject.getClass().getSimpleName());

        for (Field field : classObject.getClass().getDeclaredFields()) {
            println(field.getName() + " " + field.getGenericType());

        }
    }

    public static LinkedHashMap<Field, Object> findInputFields(Object classObject) {
        //println(classObject.getClass().getSimpleName());
        LinkedHashMap<Field, Object> map = new LinkedHashMap<Field, Object>();

        for (Field field : classObject.getClass().getDeclaredFields()) {
            //print(field.getName() + ": ");
            map.put(field, field.getType());
        }

        return map;
    }

    public static void printInputFields(LinkedHashMap<Field, Object> map) {
        for (Field field : map.keySet()) {
            Console.println(field.getName() + " -> " + map.get(field));
        }
    }

    public static LinkedHashMap<Field, Object> getInputs(Object classObject) {
        LinkedHashMap<Field, Object> results = new LinkedHashMap<Field, Object>();
        for (Field field : classObject.getClass().getDeclaredFields()) {
            if (field.getName() != "id") {
                println(String.format("Enter %s", field.getName()));
                if (field.getType().equals(int.class)) {
                    results.put(field, getInteger());
                } else if (field.getType().equals(float.class)) {
                    results.put(field, getFloat());
                } else if (field.getType().equals(String.class)) {
                    results.put(field, getInput(""));
                }
            }
        }
        return results;
    }

    public static LinkedHashMap<Field, Object> getInputs2(LinkedHashMap<Field, Object> map) {
        LinkedHashMap<Field, Object> results = new LinkedHashMap<Field, Object>();
        for (Field field : map.keySet()) {
            println(String.format("Enter %s", field.getName()));
            if (map.get(field).equals(int.class)) {
                results.put(field,getInteger());
            } else if (map.get(field).equals(float.class)) {
                results.put(field,getFloat());
            } else if (map.get(field).equals(String.class)) {
                results.put(field,getInput(""));
            }
        }
        return results;
    }

    public static void clearScreen() {
        for (int i = 0; i <100; i++) {
            println(" ");
        }
    }

    public static void print(String output, Object... args) {
        System.out.printf(output, args);
    }

    public static void println(String output, Object... args) {
        print(output + "\n", args);
    }

    static Boolean integerCheck(String input) {
        return input.matches("^\\d+$");
    }

    static Boolean doubleCheck(String input) {
        return input.matches("^[0-9]{1,3}(?:,?[0-9]{3})*(?:\\.[0-9]{2})?$");
    }

    static Boolean floatCheck(String input) {
        return input.matches("([0-9]*[.])?[0-9]+");
    }

    public static Integer getInteger() {
        String input = getInput("");
        while (true) {
            if (integerCheck(input)) break;
            else {
                println("Enter a number");
                input = getInput("");
            }
        }
        return Integer.valueOf(input);
    }

    public static Double getDouble() {
        String input = getInput("> ");
        while (true) {
            if (doubleCheck(input)) break;
            else {
                println("Enter a number");
                input = getInput("$");
            }
        }
        return Double.valueOf(input);
    }

    public static Float getFloat() {
        String input = getInput("> ");
        while (true) {
            if (floatCheck(input)) break;
            else {
                println("Enter a number");
                input = getInput("$");
            }
        }
        return Float.valueOf(input);
    }

    public static String getInput(String prompt) {
        print(prompt);
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine(); //get input from user

        return input;
    }

    public static int getInput(String header, String[] options) {

        Console.clearScreen();

        int numOptions = options.length;
        int numRows = (numOptions+1) >> 1; // this is how the cool kids divide by two
        String output = StringUtils.center(header,86) + "\n\n";

        String[] rows = new String[numRows];

        for (int i = 0; i < numRows; i++){
            rows[i] = String.format("%d | %-40s", 2*i+1, options[2*i]);
            if (2*i + 1 < numOptions) {
                rows[i] += String.format("%40s | %d", options[2*i + 1], 2*(i+1));
            }
            rows[i] += "\n";
        }

        for (int i = 0; i < numRows; i++) {
            output += rows[i];
        }

        println(output);

        return Console.getInteger(numOptions);

    }

    public static Integer getInteger(int max) {
        String input = getInput("");
        while (true) {
            if (integerCheck(input)) {
                if (Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= max) {
                    break;
                } else {
                    println("Enter a number between 1 and " + Integer.toString(max));
                    input = getInput("");
                }
            }
            else {
                println("Enter a number");
                input = getInput("");
            }
        }
        return Integer.valueOf(input);
    }

}