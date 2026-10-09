package mazenscode.good;

import java.util.List;

public class GoodMain {

    private static ShippingOrder shippingOrder;

    static void shipAll(List<Order> orders) {
        for (Order order : orders) {
            shippingOrder.ship(order);
        }
    }

    public static void main(String[] args) {

        Customer customer = new Customer("Sara", "sara@example.com");
        Order order = new DeliveryOrder("Laptop", 1200.0);

        new UserManagement().placeOrder(customer, order, new VisaPayment());

        try {
            new OrderManager().processPayment(new AmericanExpress(), order);
        } catch (UnsupportedOperationException e) {
            System.out.println("Payment failed: " + e.getMessage());
        }

        try {
            shipAll(List.of(new DeliveryOrder("Phone", 800.0), new PickUpOrder("Book", 20.0)));
        } catch (UnsupportedOperationException e) {
            System.out.println("Shipping failed: " + e.getMessage());
        }

    }

}
