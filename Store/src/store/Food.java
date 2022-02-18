package store;

import java.time.LocalDate;
import store.ENUMS.Category;
import interfaces.Persihable;

/**
 *
 * @author zoranhome
 * @desc Food class that extends the abstract product class
 */
public class Food extends Product implements Persihable {

//  Object fields
    private LocalDate expirationDate; // Create a date object
    private Category ctg = Category.FOOD;
    private int year, month, day;

// Constructor
    Food(String name, String brand, double price, double quantity, int year, int month, int day) {
        super(name, brand, price, quantity);
        this.expirationDate = parseDate(year, month, day);

    }

// Getters & Setters
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Category getCtg() {
        return ctg;
    }

// methods
    // @desc public method to parde input  date for the expirationDate
    // @params int year int month int day
    public LocalDate parseDate(int year, int month, int day) {
        LocalDate date = LocalDate.of(year, month, day);
        return date;
    }

}
