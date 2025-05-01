import java.util.Scanner;

interface State {
    void handle(char ch, StateContext context);
}

class StateContext {
    State state; 
    StateContext() {
        this.state = new VacantState();
    }
    void setState(State state) {
        this.state = state;
    }
    void process(char ch) {
        state.handle(ch, this);
    }
}

class VacantState implements State {
    public void handle(char ch, StateContext context) {
        if (Character.isDigit(ch)) {
            System.out.println(ch + " -> int");
            context.setState(new IntState());
        } else if (Character.isLetter(ch)) {
            System.out.println(ch + " -> variable");
            context.setState(new VariableState());
        } 
        else {
            System.out.println(ch + " -> invalid");
            context.setState(new InvalidState());
        }
    }
}


class IntState implements State {
    public void handle(char ch, StateContext context) {
        if (ch == '.') {
            System.out.println(ch + " -> intermediate");
            context.setState(new IntermediateState());
        } else if (Character.isDigit(ch)) {
            System.out.println(ch + " -> int");
        } else {
            System.out.println(ch + " -> invalid");
            context.setState(new InvalidState());
        }
    }
}

class IntermediateState implements State {
    public void handle(char ch, StateContext context) {
        if (Character.isDigit(ch)) {
            System.out.println(ch + " -> float");
            context.setState(new FloatState());
        } else {
            System.out.println(ch + " -> invalid");
            context.setState(new InvalidState());
        }
    }
}

class FloatState implements State {
    public void handle(char ch, StateContext context) {
        if (Character.isDigit(ch)) {
            System.out.println(ch + " -> float");
        } 
        else {
            System.out.println(ch + " -> invalid");
            context.setState(new InvalidState());
        }
    }
}

class VariableState implements State {
    public void handle(char ch, StateContext context) {
        if(Character.isAlphabetic(ch)){
            System.out.println(ch + " -> variable");
        }
        else{
            System.out.println(ch + " -> invalid");
            context.setState(new InvalidState());
        }
        
    }
}

class InvalidState implements State {
    public void handle(char ch, StateContext context) {
        System.out.println(ch + " -> invalid");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the input string: ");
        String input = scanner.nextLine();
        scanner.close();

        StateContext context = new StateContext();

        System.out.println("Processing states:");
        for (char ch : input.toCharArray()) {
            context.process(ch);
        }
    }
}
