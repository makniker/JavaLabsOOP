package lab2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Caller {
    private final ClassWithAnnotation classWithAnnotation = new ClassWithAnnotation();
    public void call() throws InvocationTargetException, IllegalAccessException {
        Method[] methods = classWithAnnotation.getClass().getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            int count = method.getAnnotation(MyAnnotation.class).numberOfCalls();
            System.out.println("Invoke " + method.getName() + " " + count + " times");
            for (int j = 0; j < count; j++) {
                method.invoke(classWithAnnotation, j, j);
            }
        }
    }
}
