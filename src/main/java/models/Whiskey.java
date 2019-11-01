package models;

public class Whiskey {

    private float volume;
    private String brand;
    private int id;
    private String name;
    private int qty;
    private float price;

    public Whiskey() {
    }

    public Whiskey(int id, String name, String brand, float volume, int qty, float price) {
        this.volume = volume;
        this.brand = brand;
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.price = price;
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
}
