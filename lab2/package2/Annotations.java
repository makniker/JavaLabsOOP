package lab2.package2;

public class Annotations {
    public static void main(String[] args){
        Caller caller = new Caller();
        try {
            caller.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
