package services;

import models.Whiskey;

import java.util.ArrayList;

public class WhiskeyService {

    private static int nextId = 1;  // (1)

    private ArrayList<Whiskey> inventory = new ArrayList<>();  // (2)

    public Whiskey create(String name, String brand, float volume, int quantity, float price) {

        // (2)
        Whiskey createdWhiskey = new Whiskey(nextId++, name, brand, volume, quantity, price);

        // (3)
        inventory.add(createdWhiskey);

        // (4)
        return createdWhiskey;
    }

    public Whiskey create() {

        // (2)
        Whiskey createdWhiskey = new Whiskey(nextId++, "defaultName", "defaultBrand", 10.5f, 2, 12.99f);

        // (3)
        inventory.add(createdWhiskey);

        // (4)
        return createdWhiskey;
    }

    //read
    public Whiskey findWhiskey(int id) {
        for (Whiskey whiskey: inventory) {
            if (whiskey.getId() == id) {
                return whiskey;
            }
        }
        return null;
    }

    //read all
    public Whiskey[] findAll() {
        return inventory.toArray(new Whiskey[inventory.size()]);
    }

    //delete
    public boolean delete(int id) {
        // should remove the object with this id from the ArrayList if exits and return true.
        // Otherwise return false
        return this.inventory.remove(findWhiskey(id));
    }

    // for testing
    public static void clear() {
        WhiskeyService.nextId = 1;
    }
}
