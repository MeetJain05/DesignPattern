import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String status);
}

interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

class Order implements Subject {
    private String status;
    private final List<Observer> customers = new ArrayList<>();

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        customers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        customers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : customers) {
            o.update(status);
        }
    }
}

class Customer implements Observer {
    private final String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(String status) {
        System.out.println("Hey " + name + ", your order is " + status + "!");
    }
}


public class CafeObserver {
    public static void main(String[] args) {
        Order order = new Order();

        Customer alice = new Customer("Alice");
        Customer bob = new Customer("Bob");

        order.addObserver(alice);
        order.addObserver(bob);

        System.out.println("Barista: Preparing the order...");
        order.setStatus("Ready"); 
    }
}
