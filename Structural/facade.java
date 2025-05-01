class TV{
    public void turnOn() {
        System.out.println("TV is turned on.");
    }
    public void turnOff() {
        System.out.println("TV is turned off.");
    }
}
class SoundSystem{
    public void turnOn() {
        System.out.println("Sound system is turned on.");
    }
    public void turnOff() {
        System.out.println("Sound system is turned off.");
    }
}
class StreamingService{
    public void startStreaming() {
        System.out.println("Streaming service is started.");
    }
    public void stopStreaming() {
        System.out.println("Streaming service is stopped.");
    }
}
class HometheatreFacade{
    private TV tv;
    private SoundSystem soundSystem;
    private StreamingService streamingService;

    public HometheatreFacade() {
        tv = new TV();
        soundSystem = new SoundSystem();
        streamingService = new StreamingService();
    }

    public void watchMovie() {
        tv.turnOn();
        soundSystem.turnOn();
        streamingService.startStreaming();
        System.out.println("Enjoy your movie!");
    }

    public void endMovie() {
        streamingService.stopStreaming();
        soundSystem.turnOff();
        tv.turnOff();
        System.out.println("Movie ended.");
    }
}
public class facade {
    public static void main(String[] args) {
        HometheatreFacade homeTheatre = new HometheatreFacade();
        homeTheatre.watchMovie();
        homeTheatre.endMovie();
        System.out.println("Home theatre system is now off.");
    }
}
