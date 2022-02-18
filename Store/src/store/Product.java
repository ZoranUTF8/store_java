package store;

import java.text.DecimalFormat;
import store.ENUMS.Category;

/**
 *
 * @author zoranhome
 */
public abstract class Product {

    // FIELDS
    DecimalFormat ft = new DecimalFormat("#.##");

// add unique id
    private String name, brand;
    private double price, quantity;
    private Category ctg;

    // CONSTRUCTOR
    public Product(String name, String brand, double price, double quantity) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
    }

//    GETTERS & SETTER
    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public Category getCtg() {
        return ctg;
    }

//    Object toString() override
    @Override
    public String toString() {
        return this.name + " " + this.brand + "\n\n" + this.getQuantity() + " x " + "$" + this.getPrice() + " = $" + formatPrice(getTotal(this.getPrice(), this.getQuantity())) + "\n\n";

    }

    // methods
//    @desc Get total price
//    @params double price double quantity
    public double getTotal(double price, double quantity) {
        return (quantity * price);
    }

    //    @desc Format price
//    @params double price
    public String formatPrice(double price) {
        return ft.format(price);
    }
}
