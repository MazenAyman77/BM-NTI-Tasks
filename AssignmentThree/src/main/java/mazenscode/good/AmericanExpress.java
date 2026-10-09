package mazenscode.good;

public class AmericanExpress implements Payment {
    @Override
    public void process() {
        System.out.println("Processing american express card payments...");
    }
}
