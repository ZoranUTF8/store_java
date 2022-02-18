package store;

import interfaces.Persihable;
import java.time.LocalDate;
import store.ENUMS.Category;

/**
 *
 * @author zoranhome
 */
public class Bevarages extends Product implements Persihable {

    // Constructor
    public Bevarages(String name, String brand, double price, double quantity, int year, int month, int day) {
        super(name, brand, price, quantity);
        this.expirationDate = parseDate(year, month, day);
    }

    //  Object fields
    private LocalDate expirationDate; // Create a date object
    private Category ctg = Category.BEVERAGES;

    // methods
    // @desc Parse date from the constructor and create the expiration date object of LocalDate type
    // @params year int month int day int
    public LocalDate parseDate(int year, int month, int day) {
        LocalDate date = LocalDate.of(year, month, day);
        return date;
    }

    // getters  & setters
    public Category getCtg() {
        return ctg;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

}
