interface Monitor{
    public void buildMonitor();
}

interface Keyboard{
    public void buildKeyboard();
}

class DellMonitor implements Monitor{
    public void buildMonitor(){
        System.out.println("Dell Monitor is built");
    }
}
class DellKeyboard implements Keyboard{
    public void buildKeyboard(){
        System.out.println("Dell Keyboard is built");
    }
}

class HPMonitor implements Monitor{
    public void buildMonitor(){
        System.out.println("HP Monitor is built");
    }
}
class HPKeyboard implements Keyboard{
    public void buildKeyboard(){
        System.out.println("HP Keyboard is built");
    }
}
class DellFactory extends Company{
    @Override
    public Monitor getMonitor(){
        return new DellMonitor();
    }
    @Override
    public Keyboard getKeyboard(){
        return new DellKeyboard();
    }
}

class HPFactory extends Company{
    @Override
    public Monitor getMonitor(){
        return new HPMonitor();
    }
    @Override
    public Keyboard getKeyboard(){
        return new HPKeyboard();
    }
}

abstract class Company{ // abstract factory
    public abstract Monitor getMonitor();
    public abstract Keyboard getKeyboard();
}

public class abstractfactory {
    public static void main(String[] args) {
        Company dell = new DellFactory();
        dell.getMonitor().buildMonitor();
        dell.getKeyboard().buildKeyboard();

        Company hp = new HPFactory();
        hp.getMonitor().buildMonitor();
        hp.getKeyboard().buildKeyboard();
    }
}
