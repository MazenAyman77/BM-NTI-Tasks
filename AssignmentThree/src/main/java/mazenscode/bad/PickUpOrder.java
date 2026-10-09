package mazenscode.bad;

public class PickUpOrder extends Order{

    PickUpOrder(String name, double price) { super(name, price); }

    @Override
    void ship() {
        throw new UnsupportedOperationException("Pick-up orders can't be shipped");
    }

}
