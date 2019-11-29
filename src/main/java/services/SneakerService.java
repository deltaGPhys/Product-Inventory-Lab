package services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import models.Sneaker;
import models.Whiskey;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SneakerService {

    private static int nextId = 1;  // (1)

    private ArrayList<Sneaker> inventory = new ArrayList<>();  // (2)

    public SneakerService() {
        loadData();
    }

    public Sneaker create(String name, String brand, String sport, float size, int quantity, float price) {

        Sneaker createdSneaker = new Sneaker(nextId++, name, brand, sport, size, quantity, price);
        inventory.add(createdSneaker);

        saveData();
        return createdSneaker;

    }

    public Sneaker create(Sneaker sneaker) {
        for (int i=1; i<=this.inventory.size(); i++){
            if (this.findSneaker(i) == null) {
                sneaker.setId(i);
            }
        }

        if (sneaker.getId() == 0) {
            sneaker.setId(nextId++);
        }
        inventory.add(sneaker);

        saveData();
        return sneaker;
    }

    public Sneaker create() {

        Sneaker createdSneaker = new Sneaker(nextId++, "defaultName", "defaultBrand", "defaultSport", 10.5f, 2, 12.99f);
        inventory.add(createdSneaker);

        saveData();
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
        boolean result = this.inventory.remove(findSneaker(id));
        if (result) {
            saveData();
        }
        return result;
    }

    // for testing
    public static void clear() {
        SneakerService.nextId = 1;
    }

    public void saveData()  {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(new File("sneaker.json"), inventory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadData() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.inventory = objectMapper.readValue(new File("sneaker.json"), new TypeReference<ArrayList<Sneaker>>(){});
            int maxId = 0;
            for (Sneaker s : inventory) {
                if (s.getId() > maxId) {
                    maxId = s.getId();
                }
            }
            nextId = ++maxId;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
