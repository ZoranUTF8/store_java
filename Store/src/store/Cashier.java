package store;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import store.ENUMS.Category;

/**
 *
 * @author zoranhome
 */
public class Cashier {

    // @desc Static cashier function to print the receipt
    // @params List cart LocalDateTime dateOfPurchase
    static void printReceipt(List cart, LocalDateTime dateOfPurchase) {
        DecimalFormat ft = new DecimalFormat("#.##");

        // Convert the purscahse date to the desired format
        LocalDateTime now = dateOfPurchase;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = now.format(format);

        System.out.println("Date: " + formatDateTime + "\n");
        System.out.println("---Products---\n");

//        Print out the items in the cart
        for (Object s : cart) {
            // get current index of element in the cart arrayList
            int currIndex = cart.indexOf(s);

            System.out.println(s + "\n");
        }

        System.out.println("-----------------------------------------------------------------------------------\n");

//        Calculate the subtotal and print out 
        System.out.printf("SUBTOTAL: $ " + ft.format(Double.valueOf(Cashier.getSubtotal(cart))) + "\n\n");
//        Calculate the discount total and print out
        System.out.printf("DISCOUNT: -$" + ft.format(Double.valueOf(Cashier.getDiscount(cart))) + "\n\n\n");
//        Calculate the total after discount is removed from the subtotal and print out
        System.out.printf("TOTAL: $ " + ft.format(Double.valueOf(Cashier.getTotal(Cashier.getSubtotal(cart), Cashier.getDiscount(cart)))) + "\n");

    }

    // @desc Static method calculate the subtotal
    // @params List cart
    static Double getSubtotal(List cart) {
        double subtotal = 0;

        for (Object s : cart) {
            // get current index of element in arrayList
            int currIndex = cart.indexOf(s);
            Product currProduct = (Product) cart.get(currIndex);

            subtotal += currProduct.getTotal(currProduct.getPrice(), currProduct.getQuantity());
        }

        return subtotal;
    }

    // @desc Static methid to calcualte total discount
    // @params List cart
    static Double getDiscount(List cart) {

//        Local fields
        Category currCtg;
        LocalDate currDate = LocalDate.now();
        double discountAll = 0;

//        Get current product from the cart
        for (Object s : cart) {

//             get current index of element in arrayList & get the product
            int currIndex = cart.indexOf(s);

            Product currProduct = (Product) cart.get(currIndex);
//              get current product category
            currCtg = currProduct.getCtg();

//            use switch to calculate the discount based uppon the category
            switch (currCtg) {

//                APPLIANCES category case
                case APPLIANCES:
                    double totalDiscount = 0.0;
                    String result;
                    if (currProduct.getPrice() > 999) {

                        // get current day of the week
                        String currDay = LocalDate.now().getDayOfWeek().name();

                        if ("SATURDAY".equals(currDay) || "SUNDAY".equals(currDay)) {
                            double disscountAppl = 0.07;
                            double total = currProduct.getQuantity() * currProduct.getPrice();
                            totalDiscount = total * disscountAppl;

                            discountAll += totalDiscount;

                        }
                    }
                    break;

//                    FOOD,BEVERAGES category case
                case FOOD,BEVERAGES:

                    double totalDiscountFood = 0.0;
                    double totalDiscountBevarages = 0.0;

//                    Check category of perishable
                    if (currCtg.equals(Category.FOOD)) {
//                        Cast the product to the specific product category
                        Food foodProduct = (Food) currProduct;

                        LocalDate expirationDate = foodProduct.getExpirationDate();

                        if (expirationDate.equals(currDate)) {
                            double disscountFood = 0.7;
                            double total = foodProduct.getQuantity() * foodProduct.getPrice();
                            totalDiscountFood = total * disscountFood;
                            discountAll += totalDiscountFood;

                        }

                    } else {
//                        Cast the product to the specific product category

                        Bevarages bevarageProduct = (Bevarages) currProduct;

                        LocalDate expirationDate = bevarageProduct.getExpirationDate();

                        if (expirationDate.equals(currDate)) {
                            double disscountBeva = 0.7;
                            double total = bevarageProduct.getQuantity() * bevarageProduct.getPrice();
                            totalDiscountBevarages = total * disscountBeva;

                            discountAll += totalDiscountBevarages;
                        }
                    }
                    break;

//                    CLOTHES category case
                case CLOTHES:
                    Clothes clothesProduct = (Clothes) currProduct;
                    double totalDiscountClothes = 0.0;
                    // get current day of the week
                    String currDayClothes = LocalDate.now().getDayOfWeek().name();

                    // check if correct day for discount
                    if (currDayClothes.equals("SUNDAY") || currDayClothes.equals("MONDAY")) {
                        return null;
                    } else {
                        double disscountClothes = 0.1;
                        double total = clothesProduct.getQuantity() * clothesProduct.getPrice();
                        totalDiscountClothes = total * disscountClothes;
                        discountAll += totalDiscountClothes;
                    }

                    break;
            }

        }

        return discountAll;
    }

    // @desc Static method to get the total 
    // @params String subtotal String discount
    static String getTotal(Double subtotal, Double discount) {

        String finalTotal = Double.toString(subtotal - discount);
        return finalTotal;

    }

}
