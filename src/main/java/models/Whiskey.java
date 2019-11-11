package models;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;

public class Whiskey extends SuperObject {

    protected int id;
    protected String name;
    protected String brand;
    protected float volume;
    protected int qty;
    protected float price;

    public Whiskey() {}

    public Whiskey(int id, String name, String brand, float volume, int qty, float price) {
        this.volume = volume;
        this.brand = brand;
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

//    public Whiskey(LinkedHashMap<Field,Object> inputs) throws IllegalAccessException {
//
//        for (Field field : this.getClass().getDeclaredFields()) {
//            field.set(this,inputs.get(field));
//        }
//    }

    public Whiskey(LinkedHashMap<Field,Object> inputs)  {
        super(inputs);
    }

    public float getVolume() {
        return volume;
    }

    public String getBrand() {
        return brand;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQty() {
        return qty;
    }

    public float getPrice() {
        return price;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String toString() {
        return String.format("ID: %d, Name: %s, Brand: %s, Volume: %f, Quantity: %d, Price: $%.2f", this.id, this.name, this.brand, this.volume, this.qty, this.price);
    }
}
