package lab2.package2;

import java.lang.reflect.InvocationTargetException;

public class Annotations {
    public static void main(String[] args){
        Caller caller = new Caller();
        try {
            caller.call();
        } catch (InvocationTargetException e1) {
            System.out.println("Invoke exception");
        }
        catch (IllegalAccessException e2) {
            System.out.println("IllegalAccess, cant get method");
        }
    }
}
