package mazenscode.good;

public class MasterCardPayment implements Payment {
    @Override
    public void process() {
        System.out.println("Processing master card payments...");
    }
}
