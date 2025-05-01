class Coffee implements Cloneable{
    String type;
    int price;

    public Coffee() {
        this.type = "espresso";
        this.price = 8;
    }

    public Coffee(String type, int price) {
        this.type = type;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Coffee [type=" + type + ", price=" + price + "]";
    }

    @Override
    protected Coffee clone() throws CloneNotSupportedException {
        
        return (Coffee)super.clone();
    }
    
}

public class cloningdemo{
    public static void main(String[] args) throws CloneNotSupportedException {
        Coffee c1 = new Coffee("latte",10);

        //Shallow copy
        Coffee c2 = c1;
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        c1.price = 5;
        
        System.out.println(c1.toString());
        System.out.println(c2.toString());

        //Deep copy
        Coffee c3 = c1.clone();
        c1.price = 1;
        System.out.println(c1.toString());
        System.out.println(c3.toString());
    }
    
}


