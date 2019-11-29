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

public class WhiskeyService {

    private static int nextId = 1;  // (1)

    private ArrayList<Whiskey> inventory = new ArrayList<>();  // (2)

    public WhiskeyService() {
        loadData();
    }

    public Whiskey create(String name, String brand, float volume, int quantity, float price) {

        Whiskey createdWhiskey = new Whiskey(nextId++, name, brand, volume, quantity, price);
        inventory.add(createdWhiskey);

        saveData();
        return createdWhiskey;
    }

    public Whiskey create(Whiskey whiskey) {
        for (int i=1; i<=this.inventory.size(); i++){
            if (this.findWhiskey(i) == null) {
                whiskey.setId(i);
            }
        }

        if (whiskey.getId() == 0) {
            whiskey.setId(nextId++);
        }

        inventory.add(whiskey);

        saveData();
        return whiskey;
    }

    public Whiskey create() {

        Whiskey createdWhiskey = new Whiskey(nextId++, "defaultName", "defaultBrand", 10.5f, 2, 12.99f);

        inventory.add(createdWhiskey);

        saveData();
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
        boolean result = this.inventory.remove(findWhiskey(id));

        if (result) {
            saveData();
        }
        return result;
    }

    // for testing
    public static void clear() {
        WhiskeyService.nextId = 1;
    }

    public void saveData()  {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(new File("whiskey.json"), inventory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadData(){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.inventory = objectMapper.readValue(new File("whiskey.json"), new TypeReference<ArrayList<Whiskey>>(){});
            int maxId = 0;
            for (Whiskey w : inventory) {
                if (w.getId() > maxId) {
                    maxId = w.getId();
                }
            }
            nextId = ++maxId;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
