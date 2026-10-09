package mazenscode.bad;

public class DeliveryOrder extends Order{

    DeliveryOrder(String name, double price) { super(name, price); }

    @Override
    void ship() {
        System.out.println("Delivering " + getName() + " to customer's address");
    }

}
