package mazenscode.bad;

public class Subscriber implements UserOperations{

    public void register(String name) {
        System.out.println(name + " registered");
    }

    public void login(String name) {
        throw new UnsupportedOperationException("Subscribers can't login");
    }

    public void subscribe(String name) {
        System.out.println(name + " subscribed to newsletter");
    }

}
