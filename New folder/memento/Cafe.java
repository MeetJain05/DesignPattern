package memento;

import java.util.*;

public class Cafe {
    public static void main(String[] args) {
        CafeOrder order = new CafeOrder();
        OrderHistory history = new OrderHistory();

        order.addItem("Espresso");
        history.save(order.saveState());
        System.out.println(order.getOrderDetails());

        order.addItem("Croissant");
        history.save(order.saveState());
        System.out.println(order.getOrderDetails());

        order.addItem("Cappuccino");
        history.save(order.saveState());
        System.out.println(order.getOrderDetails());

       
        order.restoreState(history.undo());
        System.out.println("After undo: " + order.getOrderDetails());

        
        order.restoreState(history.undo());
        System.out.println("After another undo: " + order.getOrderDetails());
    }
}

class CafeOrder {
    List<String> items = new ArrayList<>();

    public void addItem(String item) {
        items.add(item);
    }

    public String getOrderDetails() {
        return "Current Order: " + items;
    }

    public OrderMemento saveState() {
        return new OrderMemento(new ArrayList<>(items));
    }

    public void restoreState(OrderMemento memento) {
        if (memento != null) {
            this.items = new ArrayList<>(memento.getItems());
        }
    }
}

class OrderMemento {
    private List<String> items;

    public OrderMemento(List<String> items) {
        this.items = items;
    }

    public List<String> getItems() {
        return items;
    }
}

class OrderHistory {
    private List<OrderMemento> history = new ArrayList<>();

    public void save(OrderMemento memento) {
        if (history.size() == 5) {
            history.remove(0); 
        }
        history.add(memento);
    }

    public OrderMemento undo() {
        if (history.size() > 1) {
            history.remove(history.size() - 1);
            return history.get(history.size() - 1);
        }
        System.out.println("No more undo available.");
        return null;
    }
}
