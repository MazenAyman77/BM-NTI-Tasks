package mazenscode.bad;

public class Order {

    private final String name;
    private final double totalPrice;

    Order(String name, double totalPrice) {
        this.name = name;
        this.totalPrice = totalPrice;
    }

    String getName() { return name; }
    double getTotalPrice() { return totalPrice; }

    void ship() {
        System.out.println("Shipping " + name);
    }

}
