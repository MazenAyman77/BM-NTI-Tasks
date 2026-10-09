package mazenscode.good;


public class OrderManager {

    public void processOrder(Order order) {
        System.out.println("Processing order: " + order.getName() + " now...");
    }

    public void processPayment(Payment payment, Order order) {

        System.out.println("Processing payment of order: " + order.getName());
        System.out.println("Issuing payment for amount: " + order.getTotalPrice());
        payment.process();

    }

    void sendEmailNotification(Customer customer, String message) {
        System.out.println("Sending email notification to: " + customer.getEmail()
                + " with message: " + message);
    }

}