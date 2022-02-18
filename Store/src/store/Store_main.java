package store;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import store.ENUMS.CLOTHES_SIZES;

/**
 *
 * @author zoran janjic
 */
public class Store_main {

    public static void main(String[] args) {

        // create four(4) product objects
        // Food Object            NAME       BRAND   PRICE AMOUNT EXPIRATION DATE
        Product apples = new Food("apples", "BrandA", 1.50, 2.45, 2021, 06, 04);

        // Bevarage Object           NAME     BRAND   PRICE   AMOUNT    EXPIRATION DATE
        Product milk = new Bevarages("milk", "BrandM", 0.99, 3, 2022, 02, 02);

        // Clothes Object              NAME       BRAND    PRICE  AMOUNT    SIZE ENUM       COLOR
        Product T_shirt = new Clothes("T-shirt", "BrandT", 15.99, 2, CLOTHES_SIZES.M, "violet");

        // Appliances Object             NAME     BRAND     PRICE AMOUNT    MODEL      WEIGHT  PRODUCTION DATE
        Product laptop = new Appliances("laptop", "BrandL", 2345, 1, "ModelL", 1.125, 2021, 03, 03);

        // Create an ArrayList object to represent the cart
        List<Product> cart = new ArrayList<>();

        // Create time and date of tp be the date of purchase
        LocalDateTime now = LocalDateTime.now();

        // Add the created items to the cart
        cart.add(apples);
        cart.add(milk);
        cart.add(T_shirt);
        cart.add(laptop);

        // Call cashier method to print out the receipt
        Cashier.printReceipt(cart, now);

    }
}
