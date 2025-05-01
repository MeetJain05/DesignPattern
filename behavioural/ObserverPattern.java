package behavioural;
import java.util.ArrayList;
import java.util.List;

interface Observer {
    public void update(String vidname);
}

class Subscriber implements Observer{
    private String name;

    Subscriber(String name) {
        this.name = name;
    }

    public void update(String vidname){
        System.out.println(name + " New video uploaded! " + vidname);
    }
}

class YoutubeChannel {
    private String name;
    private List<Observer> subs = new ArrayList<>();

    YoutubeChannel(String name) {
        this.name = name;
    }

    void subscribe(Observer observer) {
        subs.add(observer);
    }

    void unsubscribe(Observer observer) {
        subs.remove(observer);
    }

    void notifysubs(String vidname){
        for(Observer sub : subs){
            sub.update(vidname);
        }
    }

    void uploadvideo(String videoname){
        System.out.println("New video uploaded: " + videoname);
        notifysubs(videoname);
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
    YoutubeChannel beast = new YoutubeChannel("MrBeast");
    Subscriber sub1 = new Subscriber("Meet Jain");
    Subscriber sub2 = new Subscriber("Dev");
    Subscriber sub3 = new Subscriber("Vedesh");

    beast.subscribe(sub1);
    beast.subscribe(sub2);
    beast.subscribe(sub3);
    beast.uploadvideo("How to make a game in Java?");
    beast.unsubscribe(sub2);
    beast.uploadvideo("How to make a game in C++?");
    }
}
