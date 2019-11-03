package services;

import models.Sneaker;

import java.util.ArrayList;

public class SneakerService {

    private static int nextId = 1;  // (1)

    private ArrayList<Sneaker> inventory = new ArrayList<>();  // (2)

    public Sneaker create(String name, String brand, String sport, float size, int quantity, float price) {

        // (2)
        Sneaker createdSneaker = new Sneaker(nextId++, name, brand, sport, size, quantity, price);

        // (3)
        inventory.add(createdSneaker);

        // (4)
        return createdSneaker;
    }

    public Sneaker create() {

        // (2)
        Sneaker createdSneaker = new Sneaker(nextId++, "defaultName", "defaultBrand", "defaultSport", 10.5f, 2, 12.99f);

        // (3)
        inventory.add(createdSneaker);

        // (4)
        return createdSneaker;
    }

    //read
    public Sneaker findSneaker(int id) {
        for (Sneaker sneaker: inventory) {
            if (sneaker.getId() == id) {
                return sneaker;
            }
        }
        return null;
    }

    //read all
    public Sneaker[] findAll() {
        return inventory.toArray(new Sneaker[inventory.size()]);
    }

    //delete
    public boolean delete(int id) {
        // should remove the object with this id from the ArrayList if exits and return true.
        // Otherwise return false
        return this.inventory.remove(findSneaker(id));
    }

    // for testing
    public static void clear() {
        SneakerService.nextId = 1;
    }
}
