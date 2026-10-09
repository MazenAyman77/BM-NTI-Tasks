package mazenscode.good;

public class DeliveryOrder extends Order implements ShippingOrder{

    DeliveryOrder(String name, double totalPrice) {
        super(name, totalPrice);
    }


    @Override
    public void ship(Order order) {
        System.out.println("Delivering " + getName() + " to customer's address");
    }
}
