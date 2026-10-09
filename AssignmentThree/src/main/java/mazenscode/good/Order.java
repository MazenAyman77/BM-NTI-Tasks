package mazenscode.good;

public class Order {

    private final String name;
    private final double totalPrice;

    Order(String name, double totalPrice) {
        this.name = name;
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
