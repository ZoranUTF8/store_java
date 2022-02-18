package store;

import java.time.LocalDate;
import store.ENUMS.Category;
import store.ENUMS.CLOTHES_SIZES;

/**
 *
 * @author zoranhome
 */
public class Clothes extends Product {

    //  Object fields
    private LocalDate expirationDate = LocalDate.now(); // Create a date object
    private Category ctg = Category.CLOTHES;
    CLOTHES_SIZES size;
    private String color;

    // Constructor
    public Clothes(String name, String brand, double price, double quantity, CLOTHES_SIZES size, String color) {
        super(name, brand, price, quantity);
        this.size = size;
        this.color = color;
    }

    // to string override
    @Override
    public String toString() {
        return this.getName() + " " + this.getBrand() + " " + this.getSize() + " " + this.getColor() + "\n\n" + this.getQuantity() + " x " + "$" + this.getPrice() + " = $" + getTotal(this.getPrice(), this.getQuantity()) + "\n\n";
    }

    // getters & setters
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public CLOTHES_SIZES getSize() {
        return size;
    }

    public Category getCtg() {
        return ctg;
    }

    // methods
    // @desc public method to get total get price 
    // @params double price double quantity
    @Override
    public double getTotal(double price, double quantity) {
        return (quantity * price);
    }
}
