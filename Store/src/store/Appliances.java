package store;

import java.time.LocalDate;
import store.ENUMS.Category;

/**
 *
 * @author zoranhome
 */
public class Appliances extends Product {

//   Object fields
    private String model;
    private LocalDate productionDate = LocalDate.now(); // Create a date object
    private Category ctg = Category.APPLIANCES;
    private double weight, totalDiscount;

// Constructor
    public Appliances(String name, String brand, double price, double quantity, String model, double weight, int year, int month, int day) {
        super(name, brand, price, quantity);
        this.model = model;
        this.weight = weight;
        this.productionDate = productionDate;
    }

    // to string override
    @Override
    public String toString() {
        return this.getName() + " " + this.getBrand() + " " + this.model + "\n\n" + this.getQuantity() + " x " + "$" + this.getPrice() + " = $" + getTotal(this.getPrice(), this.getQuantity()) + "\n\n";
    }

    // methods
    // @desc calcualte total and discount
    // @desc and 7% discount on all appliances that cost above $999 and are purchased during the weekend.
    public double getTotal(double price, double quantity) {

        return (quantity * price);
    }

    // getters & setters
    public double getTotalDiscount() {
        return totalDiscount;
    }

    public Category getCtg() {
        return ctg;
    }

}
