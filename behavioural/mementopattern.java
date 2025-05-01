package behavioural;
import java.util.ArrayList;
import java.util.List;
// Memento Pattern: Used to restore the state of an object to a previous state.

class Memento{
    private String state;

    public Memento(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }
}

class Originator{
    private String state;
    public void setState(String state){
        this.state = state;
    }
    public String getState(){
        return state;
    }

    public Memento saveStateToMemento(){
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento){
        state = memento.getState(); //restore state from memento
    }
}

class Caretaker{
    private Memento memento;
    private Originator originator;

    List<Memento> history = new ArrayList<>();

    public Caretaker(Originator originator){
        this.originator = originator;
    }

    public void saveState(){
        memento = originator.saveStateToMemento();
        history.add(memento); //save state to history
    }
    public void restoreState(int index){
        if(index < history.size()){
            memento = history.get(index);
            originator.getStateFromMemento(memento); //restore state from memento
            System.out.println("Restored state: " + originator.getState()); //print restored state
        }
        else{
            System.out.println("No state found at index: " + index);
        }
    }
}

public class mementopattern {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker(originator);

        originator.setState("State 1");
        caretaker.saveState();
        System.out.println("Current State: " + originator.getState());

        originator.setState("State 2");
        caretaker.saveState();
        System.out.println("Current State: " + originator.getState());

        originator.setState("State 3");
        caretaker.saveState();
        System.out.println("Current State: " + originator.getState());

        // Restore to previous states
        caretaker.restoreState(0); // Output: Restored state: State 1
        caretaker.restoreState(1); // Output: Restored state: State 2
    }
}
