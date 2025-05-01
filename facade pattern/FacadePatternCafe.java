class CoffeeMachine {
    void brewCoffee() {
        System.out.println("Brewing coffee...");
    }
}

class MilkFrother {
    void frothMilk() {
        System.out.println("Frothing milk...");
    }
}

class PaymentProcessor {
    void processPayment() {
        System.out.println("Processing payment...");
    }
}

class CafeFacade {
    CoffeeMachine coffeeMachine;
    MilkFrother milkFrother;
    PaymentProcessor paymentProcessor;

    public CafeFacade() {
        this.coffeeMachine = new CoffeeMachine();
        this.milkFrother = new MilkFrother();
        this.paymentProcessor = new PaymentProcessor();
    }

    public void orderLatte() {
        System.out.println("Ordering a Latte...");
        paymentProcessor.processPayment();
        coffeeMachine.brewCoffee();
        milkFrother.frothMilk();
        System.out.println("Latte is ready!");
    }

    public void orderEspresso() {
        System.out.println("Ordering an Espresso...");
        paymentProcessor.processPayment();
        coffeeMachine.brewCoffee();
        System.out.println("Espresso is ready!");
    }
}

public class FacadePatternCafe {
    public static void main(String[] args) {
        CafeFacade cafe = new CafeFacade();
        
        cafe.orderLatte();
        System.out.println();
        cafe.orderEspresso();
    }
}
