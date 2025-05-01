interface OS{
    void spec();
}

class Android implements OS{
    public void spec(){
        System.out.println("Most popular OS in the world");
    }
}
class IOS implements OS{
    public void spec(){
        System.out.println("Most secure OS in the world");
    }
}
class Windows implements OS{
    public void spec(){
        System.out.println("Most popular OS in the world for PC");
    }
}

class OSFactory{
    public OS getInstance(String str){
        if(str.equals("Android")){
            return new Android();
        }else if(str.equals("IOS")){
            return new IOS();
        }else if(str.equals("Windows")){
            return new Windows();
        }else{
            return null;
        }
    }
}

public class Factory{
    public static void main(String[] args){
        OSFactory osf = new OSFactory();
        OS os = osf.getInstance("IOS");
        os.spec();
    }
}