interface twopincharger{
    void charge();
}

class threepinsocket{
    void charge(){
        System.out.println("Charging using three pin socket");
    }
}

class Adapter implements twopincharger{
    threepinsocket threepinsocket;
    public Adapter(threepinsocket threepinsocket){
        this.threepinsocket = threepinsocket;
    }

    public void charge(){
        threepinsocket.charge();
    }    
}

public class adapter {
    public static void main(String[] args){
        threepinsocket threepinsocket = new threepinsocket();
        Adapter adapter = new Adapter(threepinsocket);
        adapter.charge();
    }
}
