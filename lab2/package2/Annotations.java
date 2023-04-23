package lab2.package2;

import java.lang.reflect.InvocationTargetException;

public class Annotations {
    public static void main(String[] args){
        Caller caller = new Caller();
        try {
            caller.callMethodsWitAnnotation();
        } catch (InvocationTargetException e1) {
            System.out.println("Invoke exception");
        } catch (IllegalAccessException e2) {
            System.out.println("IllegalAccess, cant get method");
        } catch (ClassNotFoundException e3) {
            System.out.println("cant found class");
        } catch (InstantiationException e4) {
            System.out.println("cant instantiation class");
        } catch (NoSuchMethodException e5) {
            System.out.println("cant found method");
        }
    }
}
