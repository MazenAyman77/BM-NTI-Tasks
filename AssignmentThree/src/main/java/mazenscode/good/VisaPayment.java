package mazenscode.good;

public class VisaPayment implements Payment {
    @Override
    public void process() {
        System.out.println("Processing visa card payments...");
    }
}
