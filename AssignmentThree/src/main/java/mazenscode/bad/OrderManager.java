package mazenscode.bad;

public class OrderManager {

    public void processOrder(Order order) {
        System.out.println("Processing order: " + order.getName() + " now...");
    }

    public void processPayment(Order order, Payment payment) {
        System.out.println("Processing payment of order: " + order.getName());
        System.out.println("Issuing payment for amount: " + order.getTotalPrice());
        if (payment.getType().equalsIgnoreCase("VISA")) {
            System.out.println("Processing visa card payments...");
        } else if (payment.getType().equalsIgnoreCase("MASTER_CARD")) {
            System.out.println("Processing master card payments...");
        } else if (payment.getType().equalsIgnoreCase("AMERICAN_EXPRESS")) {
            System.out.println("Processing american express card payments...");
        } else {
            throw new UnsupportedOperationException("Un supported payment...");
        }
    }

    void sendEmailNotification(Customer customer, String message) {
        System.out.println("Sending email notification to: " + customer.getEmail()
                + " with message: " + message);
    }

}
