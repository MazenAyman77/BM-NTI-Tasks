package mazenscode.bad;

public class UserManagement {

    private final OrderManager orderManager = new OrderManager();

    void placeOrder(Customer customer, Order order, Payment payment) {
        orderManager.processOrder(order);
        orderManager.processPayment(order, payment);
        orderManager.sendEmailNotification(customer, "Order " + order.getName() + " confirmed");
    }

}
