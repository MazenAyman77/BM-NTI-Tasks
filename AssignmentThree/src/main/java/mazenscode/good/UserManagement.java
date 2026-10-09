package mazenscode.good;


public class UserManagement {

    private final OrderManager orderManager = new OrderManager();

    void placeOrder(Customer customer, Order order, Payment payment) {
        orderManager.processOrder(order);
        orderManager.processPayment(payment, order);
        orderManager.sendEmailNotification(customer, "Order " + order.getName() + " confirmed");
    }

}
