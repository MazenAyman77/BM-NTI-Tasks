package mazenscode.good;

public class Customer {

    private final String name;
    private final String email;

    Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    String getName() { return name; }
    String getEmail() { return email; }

}
