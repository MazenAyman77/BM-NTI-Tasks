package mazenscode.bad;

import java.util.*;

public class BadMain {

    static void shipAll(List<Order> orders) {
        for (Order order : orders) {
            order.ship();
        }
    }

    public static void main(String[] args) {
        Customer customer = new Customer("Sara", "sara@example.com");
        Order order = new DeliveryOrder("Laptop", 1200.0);

        new UserManagement().placeOrder(customer, order, new Payment("VISA"));

        try {
            new OrderManager().processPayment(order, new Payment("PAYPAL"));
        } catch (UnsupportedOperationException e) {
            System.out.println("Payment failed: " + e.getMessage());
        }

        try {
            shipAll(List.of(new DeliveryOrder("Phone", 800.0), new PickUpOrder("Book", 20.0)));
        } catch (UnsupportedOperationException e) {
            System.out.println("Shipping failed: " + e.getMessage());
        }

        try {
            new Subscriber().login("Omar");
        } catch (UnsupportedOperationException e) {
            System.out.println("Login failed: " + e.getMessage());
        }
    }
}
