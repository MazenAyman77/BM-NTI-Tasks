package mazenscode.good;

public class Subscriber implements UserRegister, UserSubscribe {
    @Override
    public void register(String name) {
        System.out.println(name + " registered");
    }

    @Override
    public void subscribe(String name) {
        System.out.println(name + " subscribed to newsletter");
    }
}
