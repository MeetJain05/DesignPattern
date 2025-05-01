package singelton;

class CoffeeMachine {
    private static CoffeeMachine instance; 

    private CoffeeMachine() { 
        System.out.println("Coffee Machine is Ready!");
    }

    public static CoffeeMachine getInstance() {
        if (instance == null) {  
            instance = new CoffeeMachine();
        }
        return instance;
    }

    public String brewCoffee() {
        return "Coffee is ready!";
    }
}


public class Cafe {
    public static void main(String[] args) {
        CoffeeMachine machine1 = CoffeeMachine.getInstance();
        CoffeeMachine machine2 = CoffeeMachine.getInstance();

        System.out.println(machine1.brewCoffee()); 
        System.out.println(machine2.brewCoffee()); 

        System.out.println(machine1 == machine2);  // True (Both are the same instance)
    }
}
