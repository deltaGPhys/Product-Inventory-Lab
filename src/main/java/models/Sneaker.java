package models;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class Sneaker extends SuperObject {

    protected int id;
    protected String name;
    protected String brand;
    protected String sport;
    protected float size;
    protected int qty;
    protected float price;

    public Sneaker() {}

    public Sneaker(int id, String name, String brand, String sport, float size, int qty, float price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.sport = sport;
        this.size = size;
        this.qty = qty;
        this.price = price;
    }

//    public Sneaker(LinkedHashMap<Field,Object> inputs) throws IllegalAccessException {
//
//        for (Field field : this.getClass().getDeclaredFields()) {
//            field.set(this,inputs.get(field));
//        }
//    }

    public Sneaker(LinkedHashMap<Field,Object> inputs) {
        super(inputs);
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getSport() {
        return this.sport;
    }

    public float getSize() {
        return this.size;
    }

    public int getQty() {
        return this.qty;
    }

    public float getPrice() {
        return this.price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String toString() {
        return String.format("ID: %d, Name: %s, Brand: %s, Sport: %s, Size: %f, Quantity: %d, Price: $%.2f", this.id, this.name, this.brand, this.sport, this.size, this.qty, this.price);
    }

}
