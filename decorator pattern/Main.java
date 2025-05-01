interface Coffee {
    double cost();
}

class SimpleCoffee implements Coffee {
    public double cost() {
        return 5.0;
    }
}

class CoffeeDecorator implements Coffee {
    Coffee coffee;

    CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public double cost() {
        return coffee.cost();
    }
}

class MilkDecorator extends CoffeeDecorator {
    MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public double cost() {
        return coffee.cost() + 2.0;
    }
}

class SugarDecorator extends CoffeeDecorator {
    SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    public double cost() {
        return coffee.cost() + 1.0;
    }
}

public class Main {
    
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println("Plain Coffee: $" + coffee.cost());

        coffee = new MilkDecorator(coffee);
        System.out.println("Coffee with Milk: $" + coffee.cost());

        coffee = new SugarDecorator(coffee);
        System.out.println("Coffee with Milk & Sugar: $" + coffee.cost());
    }
}
