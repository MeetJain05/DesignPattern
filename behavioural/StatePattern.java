package behavioural;

interface State{
    void handle();
}

class Red implements State{
    public void handle(){
        System.out.println("Red light, stop!");
    }
}

class Green implements State{
    public void handle(){
        System.out.println("Green light, go!");
    }
}
class Yellow implements State{
    public void handle(){
        System.out.println("Yellow light, slow down!");
    }
}

// Context class
class TrafficLightContext{
    private State state;

    public void setState(State state){
        this.state = state;
    }

    public void showState(){
        if(state != null) state.handle();
        else System.out.println("No state set!");
    }
}

public class StatePattern {
    public static void main(String[] args) {
        TrafficLightContext trafficLight = new TrafficLightContext();

        State red = new Red();
        State green = new Green();
        State yellow = new Yellow();

        trafficLight.setState(red);
        trafficLight.showState(); // Output: Red light, stop!

        trafficLight.setState(green);
        trafficLight.showState(); // Output: Green light, go!

        trafficLight.setState(yellow);
        trafficLight.showState(); // Output: Yellow light, slow down!
    }
}
