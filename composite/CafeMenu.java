package composite;

import java.util.*;

interface MenuComponent {
    void display();
}

class MenuItem implements MenuComponent {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void display() {
        System.out.println("  - " + name + " ($" + price + ")");
    }
}

class MenuSection implements MenuComponent {
    private String name;
    private List<MenuComponent> components = new ArrayList<>();

    public MenuSection(String name) {
        this.name = name;
    }

    public void add(MenuComponent component) {
        components.add(component);
    }

    @Override
    public void display() {
        System.out.println("\n" + name + ":");
        components.forEach(MenuComponent::display);
    }
}

public class CafeMenu {
    public static void main(String[] args) {
        MenuSection menu = new MenuSection("Café Menu");
        MenuSection hotDrinks = new MenuSection("Hot Beverages");
        MenuSection coldDrinks = new MenuSection("Cold Beverages");

        hotDrinks.add(new MenuItem("Espresso", 2.5));
        hotDrinks.add(new MenuItem("Cappuccino", 3.5));

        coldDrinks.add(new MenuItem("Iced Coffee", 3.0));
        coldDrinks.add(new MenuItem("Berry Smoothie", 4.5));

        menu.add(hotDrinks);
        menu.add(coldDrinks);
        menu.display();
    }
}
