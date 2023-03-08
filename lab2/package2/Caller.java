package lab2.package2;

import lab2.package1.ClassWithAnnotation;
import lab2.package1.MyAnnotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Caller {
    public ClassWithAnnotation classWithAnnotation = new ClassWithAnnotation();

    public void call() throws InvocationTargetException, IllegalAccessException {
        Method[] methods = classWithAnnotation.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (!method.canAccess(classWithAnnotation)) {
                method.setAccessible(true);
                int count = method.getAnnotation(MyAnnotation.class).numberOfCalls();
                System.out.println("Invoke " + method.getName() + " " + count + " times");
                for (int j = 0; j < count; j++) {
                    method.invoke(classWithAnnotation, j, j);
                }
                method.setAccessible(false);
            }
        }
    }
}
