interface Cafe {
    void serveCoffee();
}

class RealCafe implements Cafe {
    String customerName;

    RealCafe(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public void serveCoffee() {
        System.out.println("Serving coffee to " + customerName);
    }
}

class ProxyCafe implements Cafe {
    RealCafe realCafe;
    String customerName;
    int customerAge;

    ProxyCafe(String customerName, int customerAge) {
        this.customerName = customerName;
        this.customerAge = customerAge;
    }

    @Override
    public void serveCoffee() {
        if (customerAge >= 18) {
            realCafe = new RealCafe(customerName);
            realCafe.serveCoffee();
        } else {
            System.out.println("Sorry, " + customerName + ". You must be 18 or older to order coffee.");
        }
    }
}

public class CafeProxyDemo {
    public static void main(String[] args) {
        Cafe customer1 = new ProxyCafe("Alice", 20);
        customer1.serveCoffee();

        Cafe customer2 = new ProxyCafe("Bob", 16);
        customer2.serveCoffee();
    }
}
