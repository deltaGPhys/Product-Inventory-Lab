package services;

import models.Sneaker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
            String csvFile = "/Users/josh/Desktop/Projects/Product-Inventory-Lab/Sneaker.csv";
            FileWriter writer = new FileWriter(csvFile); //(1)

            CSVUtils.writeLine(writer, new ArrayList<String>(Arrays.asList(String.valueOf(nextId))));  // (2)

            for (Sneaker s : this.inventory) {
                List<String> list = new ArrayList<>(); // (3)
                list.add(String.valueOf(s.getId()));
                list.add(s.getName());
                list.add(s.getBrand());
                list.add(s.getSport());
                list.add(String.valueOf(s.getSize()));
                list.add(String.valueOf(s.getQty()));
                list.add(String.valueOf(s.getPrice()));

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
        String csvFile = "/Users/josh/Desktop/Projects/Product-Inventory-Lab/Sneaker.csv";
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
                String sport = beer[3];
                float size = Float.parseFloat(beer[4]);
                int qty = Integer.parseInt(beer[5]);
                float price = Float.parseFloat(beer[6]);

                // (5)
                inventory.add(new Sneaker(id, name, brand, sport, size, qty, price));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
