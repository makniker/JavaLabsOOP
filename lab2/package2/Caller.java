package lab2.package2;

import lab2.package1.ClassWithAnnotation;
import lab2.package1.MyAnnotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.concurrent.ThreadLocalRandom;

public class Caller {
    public ClassWithAnnotation classWithAnnotation = new ClassWithAnnotation();

    public void call() throws InvocationTargetException, IllegalAccessException {
        Method[] methods = classWithAnnotation.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (!method.canAccess(classWithAnnotation)) {
                method.setAccessible(true);
                int count = method.getAnnotation(MyAnnotation.class).numberOfCalls();
                System.out.println("Invoke " + method.getName() + " " + count + " times");
                Type[] typeArr = method.getParameterTypes();
                Object[] obj = new Object[typeArr.length];
                boolean isDefaultType = true;
                try {
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
                            isDefaultType = false;
                        }
                    }
                    if (!isDefaultType){
                        System.out.println("Not default parametrs!");
                        method.setAccessible(false);
                        continue;
                    }
                    for (int j = 0; j < count; j++) {
                        method.invoke(classWithAnnotation, obj);
                    }
                } catch (NullPointerException e){
                    System.out.println(e.getMessage());
                }
                method.setAccessible(false);
            }
        }
    }
}
