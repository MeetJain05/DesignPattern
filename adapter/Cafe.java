interface CafeOrder {
    void placeOrder();
}

class CoffeeOrder implements CafeOrder {
    private String coffeeType;

    public CoffeeOrder(String coffeeType) {
        this.coffeeType = coffeeType;
    }

    @Override
    public void placeOrder() {
        System.out.println("Order placed for: " + coffeeType + " Coffee.");
    }
}

class TeaOrder {
    private String teaType;

    public TeaOrder(String teaType) {
        this.teaType = teaType;
    }

    public void orderTea() {
        System.out.println("Order placed for: " + teaType + " Tea.");
    }
}

class TeaOrderAdapter implements CafeOrder {
    private TeaOrder teaOrder;

    public TeaOrderAdapter(String teaType) {
        this.teaOrder = new TeaOrder(teaType);
    }

    @Override
    public void placeOrder() {
        teaOrder.orderTea();
    }
}

public class Cafe {
    public static void main(String[] args) {
        CafeOrder coffee = new CoffeeOrder("Espresso");
        coffee.placeOrder();

        CafeOrder tea = new TeaOrderAdapter("Masala");
        tea.placeOrder();
    }
}
 