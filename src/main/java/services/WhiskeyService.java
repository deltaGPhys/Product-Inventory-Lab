package services;

import models.Sneaker;
import models.Whiskey;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
            String csvFile = "/Users/josh/Desktop/Projects/Product-Inventory-Lab/Whiskey.csv";
            FileWriter writer = new FileWriter(csvFile); //(1)

            CSVUtils.writeLine(writer, new ArrayList<String>(Arrays.asList(String.valueOf(nextId))));  // (2)

            for (Whiskey w : this.inventory) {
                List<String> list = new ArrayList<>(); // (3)
                list.add(String.valueOf(w.getId()));
                list.add(w.getName());
                list.add(w.getBrand());
                list.add(String.valueOf(w.getVolume()));
                list.add(String.valueOf(w.getQty()));
                list.add(String.valueOf(w.getPrice()));

                CSVUtils.writeLine(writer, list);  // (4)
            }

            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadData(){
        // (1)
        String csvFile = "/Users/josh/Desktop/Projects/Product-Inventory-Lab/Whiskey.csv";
        String line = "";
        String csvSplitBy = ",";

        // (2)
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            nextId = Integer.parseInt(br.readLine());  // (3)

            while ((line = br.readLine()) != null) {
                // split line with comma
                String[] beer = line.split(csvSplitBy);

                // (4)
                int id = Integer.parseInt(beer[0]);
                String name = beer[1];
                String brand = beer[2];
                float volume = Float.parseFloat(beer[3]);
                int qty = Integer.parseInt(beer[5]);
                float price = Float.parseFloat(beer[6]);

                // (5)
                inventory.add(new Whiskey(id, name, brand, volume, qty, price));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
