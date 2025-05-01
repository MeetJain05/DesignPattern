interface Prototype{
    public Prototype clone();
}

class Car implements Prototype{
    private String model;
    private String colour;
    private String brand;
    private boolean sunroof;
    private String numberPlate;

    public Car(String model, String colour, String brand, boolean sunroof, String numberPlate) {
        this.model = model;
        this.colour = colour;
        this.brand = brand;
        this.sunroof = sunroof;
        this.numberPlate = numberPlate;
    }

    public Car(Car car){
        this.model = car.model;
        this.colour = car.colour;
        this.brand = car.brand;
        this.sunroof = car.sunroof;
        this.numberPlate = car.numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    @Override
    public String toString() {
        return "Car [model=" + model + ", colour=" + colour + ", brand=" + brand + ", sunroof=" + sunroof
                + ", numberPlate=" + numberPlate + "]";
    }

    public Car clone(){
        return new Car(this);
    }
}

public class prot {
    public static void main(String[] args){
        Car car1 = new Car("Model S", "Red", "Tesla", true, "ABC123");
        Car car2 = car1.clone(); // Cloning the car object
        System.out.println(car1 == car2); // false, different references
        car2.setNumberPlate("XYZ789"); // Changing the number plate of the cloned car
        System.out.println("Car 1: " + car1.toString());
        System.out.println("Car 2: " + car2.toString());
    }
}
