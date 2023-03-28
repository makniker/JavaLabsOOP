package lab2.package2;

import lab2.package1.ClassWithAnnotation;
import lab2.package1.MyAnnotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.concurrent.ThreadLocalRandom;

public class Caller {
    public ClassWithAnnotation classWithAnnotation = new ClassWithAnnotation();

    public void callMethodsWitAnnotation() throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException, ClassNotFoundException {
        Method[] methods = classWithAnnotation.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (!method.canAccess(classWithAnnotation) && method.isAnnotationPresent(MyAnnotation.class)) {
                method.setAccessible(true);
                int count = method.getAnnotation(MyAnnotation.class).numberOfCalls();
                System.out.println("Invoke " + method.getName() + " " + count + " times");
                Type[] typeArr = method.getParameterTypes();
                if (typeArr.length == 0) {
                    for (int j = 0; j < count; j++) {
                        method.invoke(classWithAnnotation);
                    }
                    continue;
                }
                Object[] obj = new Object[typeArr.length];
                    for (int i = 0; i < typeArr.length; i++) {
                        if (typeArr[i].equals(int.class)) {
                            obj[i] = ThreadLocalRandom.current().nextInt();
                        } else if (typeArr[i].equals(double.class)) {
                            obj[i] = ThreadLocalRandom.current().nextDouble();
                        } else if (typeArr[i].equals(float.class)) {
                            obj[i] = ThreadLocalRandom.current().nextFloat();
                        } else if (typeArr[i].equals(boolean.class)) {
                            obj[i] = ThreadLocalRandom.current().nextBoolean();
                        } else if (typeArr[i].equals(byte.class)) {
                            obj[i] = (byte) ThreadLocalRandom.current().nextInt();
                        } else if (typeArr[i].equals(char.class)) {
                            obj[i] = (char) ThreadLocalRandom.current().nextInt(Character.MIN_VALUE, Character.MAX_VALUE);
                        } else if (typeArr[i].equals(String.class)) {
                            obj[i] = "String";
                        } else {
                            obj[i] = Class.forName(typeArr[i].getTypeName()).getConstructor().newInstance();
                        }
                    }
                    for (int j = 0; j < count; j++) {
                        method.invoke(classWithAnnotation, obj);
                    }
                method.setAccessible(false);
            }
        }
    }
}
