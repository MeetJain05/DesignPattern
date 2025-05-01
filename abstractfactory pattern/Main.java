import java.util.Scanner;

class SuperFoodFactory{
    static FoodFactory getFoodFactory(String mode){
        if(mode.equals("Pizza")){
            return new PizzaFactory();
        }
        else if(mode.equals("Drink")){
            return new DrinkFactory();
        }
        else{
            return null;
        }
    }
}

interface Eatable{
    public void serve();
}

abstract class FoodFactory{
    abstract Eatable servefood();
}

class PizzaFactory extends FoodFactory{
    Eatable servefood(){
        System.out.println("Paneer or Cheese:");
        try (Scanner sc = new Scanner(System.in)) {
            String pizza = sc.nextLine();
            if(pizza.equals("Paneer")){
                return new PaneerPizza();
            }
            else{
                return new CheesePizza();
            }
        }
    }
}

class DrinkFactory extends FoodFactory{
    Eatable servefood(){
        System.out.println("IceTea or Coffee:");
        try (Scanner sc = new Scanner(System.in)) {
            String drink = sc.nextLine();
            if(drink.equals("Coffee")){
                return new Coffee();
            }
            else{
                return new Icetea();
            }
        }
    }
}

class PaneerPizza implements Eatable{
    public void serve(){
        System.out.println("Paneer Pizza is served");
    }
}
class CheesePizza implements Eatable{
    public void serve(){
        System.out.println("Cheese Pizza is served");
    }
}

class Coffee implements Eatable{
    public void serve(){
        System.out.println("Coffee is ready ");
    }
}

class Icetea implements Eatable{
    public void serve(){
        System.out.println("Icetea is ready");
    }
}

public class Main{
    public static void main(String args[]){
        System.out.println("Choose option from: \n1.Pizza:  \n2.Drink: ");
        try (Scanner s = new Scanner(System.in)) {
            String choice = s.nextLine();
            FoodFactory foodfact = SuperFoodFactory.getFoodFactory(choice);
            Eatable food = foodfact.servefood();
            food.serve();
        }
    }
}