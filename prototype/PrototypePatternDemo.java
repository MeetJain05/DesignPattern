package prototype;
interface CafeOrder extends Cloneable {
    CafeOrder clone();
    void displayOrder();
}

class CoffeeOrder implements CafeOrder {
    private String coffeeType;
    private String milkType;
    private String sugar;
    private String size;

    public CoffeeOrder(String coffeeType, String milkType, String sugar, String size) {
        this.coffeeType = coffeeType;
        this.milkType = milkType;
        this.sugar = sugar;
        this.size = size;
    }

    @Override
    public CafeOrder clone() {
        try {
            return (CafeOrder) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public void displayOrder() {
        System.out.println("Coffee Type: " + coffeeType);
        System.out.println("Milk Type: " + milkType);
        System.out.println("Sugar: " + sugar);
        System.out.println("Size: " + size);
    }

    
    public String getCoffeeType() { return coffeeType; }
    public void setCoffeeType(String coffeeType) { this.coffeeType = coffeeType; }

    public String getMilkType() { return milkType; }
    public void setMilkType(String milkType) { this.milkType = milkType; }

    public String getSugar() { return sugar; }
    public void setSugar(String sugar) { this.sugar = sugar; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }
}

public class PrototypePatternDemo {
    public static void main(String[] args) {
        CoffeeOrder originalOrder = new CoffeeOrder("Espresso", "Almond Milk", "2 cubes", "Medium");
        
        
        CoffeeOrder clonedOrder1 = (CoffeeOrder) originalOrder.clone();
        clonedOrder1.setSize("Large");
        clonedOrder1.setSugar("No sugar");

        
        CoffeeOrder clonedOrder2 = (CoffeeOrder) originalOrder.clone();
        clonedOrder2.setCoffeeType("Cappuccino");
        clonedOrder2.setMilkType("Whole Milk");

        
        System.out.println("Original Order:");
        originalOrder.displayOrder();
        
        System.out.println("\nCloned Order 1:");
        clonedOrder1.displayOrder();
        
        System.out.println("\nCloned Order 2:");
        clonedOrder2.displayOrder();
    }
}
