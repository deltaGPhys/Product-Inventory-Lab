import models.Sneaker;
import models.Whiskey;
import services.SneakerService;
import services.WhiskeyService;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class App {

    private SneakerService sneakerService = new SneakerService();
    private WhiskeyService whiskeyService = new WhiskeyService();

    public static void main(String... args) throws IllegalAccessException {
        App application = new App();

        Object[] classes = new Object[] {new Sneaker(), new Whiskey()};
        application.init(classes);
    }

    public void init(Object[] classes) throws IllegalAccessException{
        // (4)
        // application logic here
        // call methods to take user input and interface with services
        Console.printWelcome();
//        Console.println("*********** Sneaker ************");
//        LinkedHashMap<Field, Object> inputs = Console.getInputs(new Sneaker());
//        Sneaker sneaker = new Sneaker(inputs);
//
//        Console.println("*********** Whiskey ************");
//
//        inputs = Console.getInputs(new Whiskey());
//        Whiskey whiskey = new Whiskey(inputs);
        displayMenu();
    }

    public void displayMenu() {
        String[] choices = new String[] {"Add item", "View item", "Update item", "Delete item", "Get report", "Exit"};

        handleChoice(Console.getInput("Main Menu", choices));
    }

    public void handleChoice(int choice) {
        switch (choice) {
            case 1:
                addMenuDisplay();
                displayMenu();
                break;
            case 2:
                readMenuDisplay();
                displayMenu();
                break;
            case 3:
                updateMenuDisplay();
                displayMenu();
                break;
            case 4:
                deleteMenuDisplay();
                displayMenu();
                break;
            case 5:
                reportMenuDisplay();
                displayMenu();
                break;
            case 6:
                break;
        }
    }


    public void addMenuDisplay() {
        String[] choices = new String[] {"Add Sneaker", "Add Whiskey", "Exit"};

        addMenuHandleChoice(Console.getInput("Add Item Menu", choices));
    }

    public void addMenuHandleChoice(int choice) {
        switch (choice) {
            case 1:
                sneakerService.create(new Sneaker(Console.getInputs(new Sneaker())));
                Console.getInput("Sneaker created. Press Enter to continue");
                break;
            case 2:
                whiskeyService.create(new Whiskey(Console.getInputs(new Whiskey())));
                Console.getInput("Whiskey created. Press Enter to continue");
                break;
            default:
                break;
        }
    }

    public void readMenuDisplay() {
        String[] choices = new String[] {"View Sneaker", "View Whiskey", "Exit"};

        readMenuHandleChoice(Console.getInput("View Item Menu", choices));
    }

    public void readMenuHandleChoice(int choice) {
        switch (choice) {
            case 1:
                int maxId = sneakerService.findAll().length;
                if (maxId >=1 ) {
                    Console.println("Choose a sneaker ID to view. Available sneaker IDs: 1-%d", maxId);
                    Console.println(sneakerService.findSneaker(Console.getInteger(maxId)).toString());
                } else {
                    Console.println("There are no sneakers to view");
                }
                Console.getInput("Press Enter to continue");
                break;
            case 2:
                maxId = whiskeyService.findAll().length;
                if (maxId >=1 ) {
                    Console.println("Choose a whiskey ID to view. Available whiskey IDs: 1-%d",maxId);
                    Console.println(whiskeyService.findWhiskey(Console.getInteger(maxId)).toString());
                } else {
                    Console.println("There are no whiskeys to view");
                }
                Console.getInput("Press Enter to continue");
                break;
            default:
                break;
        }
    }

    public void deleteMenuDisplay() {
        String[] choices = new String[] {"Delete Sneaker", "Delete Whiskey", "Exit"};

        deleteMenuHandleChoice(Console.getInput("Delete Item Menu", choices));
    }

    public void deleteMenuHandleChoice(int choice) {
        int itemChoice;
        switch (choice) {
            case 1:
                int maxId = sneakerService.findAll().length;
                if (maxId >=1 ) {
                    Console.println("Choose a sneaker ID to delete. Available sneakers: ");
                    for (Sneaker sneaker : sneakerService.findAll()) {
                        Console.println(sneaker.toString());
                    }
                    itemChoice = Console.getInteger();
                    Console.println(sneakerService.findSneaker(itemChoice).toString());
                    if (Console.getInput("Press Enter to delete, any other key to abort").equals("")) {
                        sneakerService.delete(itemChoice);
                    }
                } else {
                    Console.getInput("There are no sneakers to view. Press Enter to continue");
                }
                break;
            case 2:
                maxId = whiskeyService.findAll().length;
                if (maxId >=1 ) {
                    Console.println("Choose a whiskey ID to delete. Available sneakers: ");
                    for (Whiskey whiskey : whiskeyService.findAll()) {
                        Console.println(whiskey.toString());
                    }
                    itemChoice = Console.getInteger();
                    Console.println(whiskeyService.findWhiskey(itemChoice).toString());
                    if (Console.getInput("Press Enter to delete, any other key to abort").equals("")) {
                        whiskeyService.delete(itemChoice);
                    }
                } else {
                    Console.getInput("There are no whiskeys to view. Press Enter to continue");
                }
                break;
            default:
                break;
        }
    }

    public void updateMenuDisplay() {
        String[] choices = new String[] {"Update Sneaker", "Update Whiskey", "Exit"};

        updateMenuHandleChoice(Console.getInput("Update Item Menu", choices));
    }

    public void updateMenuHandleChoice(int choice) {
        int itemChoice;
        switch (choice) {
            case 1:
                int maxId = sneakerService.findAll().length;
                if (maxId >=1 ) {
                    Console.println("Choose a sneaker ID to update. Available sneakers: ");
                    for (Sneaker sneaker : sneakerService.findAll()) {
                        Console.println(sneaker.toString());
                    }
                    itemChoice = Console.getInteger();
                    Console.println(sneakerService.findSneaker(itemChoice).toString());
                    if (Console.getInput("Press Enter to update, any other key to abort").equals("")) {
                        sneakerService.delete(itemChoice);
                        sneakerService.create(new Sneaker(Console.getInputs(new Sneaker())));
                        Console.getInput("Sneaker updated. Press Enter to continue");
                    }
                } else {
                    Console.getInput("There are no sneakers to view. Press Enter to continue");
                }
                break;
            case 2:
                maxId = whiskeyService.findAll().length;
                if (maxId >=1 ) {
                    Console.println("Choose a whiskey ID to update. Available sneakers: ");
                    for (Whiskey whiskey : whiskeyService.findAll()) {
                        Console.println(whiskey.toString());
                    }
                    itemChoice = Console.getInteger();
                    Console.println(whiskeyService.findWhiskey(itemChoice).toString());
                    if (Console.getInput("Press Enter to update, any other key to abort").equals("")) {
                        whiskeyService.delete(itemChoice);
                        whiskeyService.create(new Whiskey(Console.getInputs(new Whiskey())));
                        Console.getInput("Whiskey updated. Press Enter to continue");
                    }
                } else {
                    Console.getInput("There are no whiskeys to view. Press Enter to continue");
                }
                break;
            default:
                break;
        }
    }

    public void reportMenuDisplay() {
        String[] choices = new String[] {"View Sneaker Report", "View Whiskey Report", "Exit"};

        reportMenuHandleChoice(Console.getInput("Report Menu", choices));
    }

    public void reportMenuHandleChoice(int choice) {
        int itemChoice;
        switch (choice) {
            case 1:
                int maxId = sneakerService.findAll().length;
                if (maxId >=1 ) {
                    Console.println("Total sneaker types in inventory: " + String.valueOf(maxId));
                    for (Sneaker sneaker : sneakerService.findAll()) {
                        Console.println(sneaker.toString());
                    }
                    Console.getInput("Press Enter to continue");
                } else {
                    Console.getInput("There are no sneakers to view. Press Enter to continue");
                }
                break;
            case 2:
                maxId = whiskeyService.findAll().length;
                if (maxId >=1 ) {
                    Console.println("Total whiskey types in inventory: " + String.valueOf(maxId));
                    for (Whiskey whiskey : whiskeyService.findAll()) {
                        Console.println(whiskey.toString());
                    }
                    Console.getInput("Press Enter to continue");
                } else {
                    Console.getInput("There are no whiskeys to view. Press Enter to continue");
                }
                break;
            default:
                break;
        }
    }
}