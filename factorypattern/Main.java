import java.util.Scanner;

interface Drink {
    public void serve();
}

class coffee implements Drink{ 
    public void serve(){
        System.out.println("Coffee Served");
    }
}

class icetea implements Drink{
    public void serve(){
        System.out.println("Icetea served");
    }
}

class DrinkFactory{
    public static Drink served(int option){
        if(option == 1){
            return new coffee();
        }
        else return new icetea();
    }
}

public class Main{
    public static void main(String[] args) {
        System.out.println("Choose option from: \nCoffee: 1 \nIcetea: 2");
        Scanner in = new Scanner(System.in);
        int option = in.nextInt();
        in.close();
        DrinkFactory.served(option).serve();
    }
}