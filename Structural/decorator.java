interface Coffee {
    String getDescription();
    double cost();
}
class BasicCoffee implements Coffee {
    public String getDescription() {
        return "Basic Coffee";
    }
    public double cost() {
        return 5.0;
    }
}

abstract class Decorator implements Coffee {
    Coffee coffee;
    public Decorator(Coffee coffee) {
        this.coffee = coffee;
    }
    public String getDescription() {
        return coffee.getDescription();
    }
    public double cost() {
        return coffee.cost();
    }
}
class MilkDecorator extends Decorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }
    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }
    public double cost() {
        return coffee.cost() + 1.5;
    }
}
class SugarDecorator extends Decorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }
    public String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }
    public double cost() {
        return coffee.cost() + 0.5;
    }
}
public class decorator {
    public static void main(String[] args) {
        // Create a basic coffee
        Coffee coffee = new BasicCoffee();
        System.out.println(coffee.getDescription() + " costs: " + coffee.cost());

        // Add milk to the coffee
        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " costs: " + coffee.cost());

        // Add sugar to the coffee
        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " costs: " + coffee.cost());
    }
}
