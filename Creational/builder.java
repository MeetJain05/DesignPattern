class Car{
    private final String model;
    private final String color;
    private final String wheels;
    private final String seats;
    private final boolean sunroof;
    
    Car(String model, String color, String wheels, String seats, boolean sunroof) {
        this.model = model;
        this.color = color;
        this.wheels = wheels;
        this.seats = seats;
        this.sunroof = sunroof;
    }

    @Override
    public String toString(){
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", wheels='" + wheels + '\'' +
                ", seats='" + seats + '\'' +
                ", sunroof=" + sunroof +
                '}';
    }
}
class Carbuilder{
    private String model = "BMW";
    private String color = "Black";
    private String wheels = "Alloy";
    private String seats = "Leather";
    private boolean sunroof = true;

    public Carbuilder setModel(String model) {
        this.model = model;
        return this;
    }
    public Carbuilder setColor(String color) {
        this.color = color;
        return this;
    }
    public Carbuilder setWheels(String wheels) {
        this.wheels = wheels;
        return this;
    }
    public Carbuilder setSeats(String seats) {
        this.seats = seats;
        return this;
    }
    public Carbuilder setSunroof(boolean sunroof) {
        this.sunroof = sunroof;
        return this;
    }

    public Car buildcar(){
        return new Car(model, color, wheels, seats, sunroof);
    }
    
}
public class builder {
    public static void main(String[] args) {
    Carbuilder cb = new Carbuilder();
    cb.setColor("Red")
       .setWheels("Alloy")
       .setSunroof(true);

    Car car = cb.buildcar();
    System.out.println(car.toString());
    }
}
