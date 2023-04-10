package lab2.package2;

import lab2.package1.ClassWithAnnotation;
import lab2.package1.MyAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.concurrent.ThreadLocalRandom;

public class Caller {
    final public ClassWithAnnotation classWithAnnotation = new ClassWithAnnotation();

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
                    obj[i] = newClassInst(typeArr[i]);
                }
                for (int j = 0; j < count; j++) {
                    method.invoke(classWithAnnotation, obj);
                }
                method.setAccessible(false);
            }
        }
    }

    private Object newClassInst(Type type) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        if (type.equals(int.class)) {
            return ThreadLocalRandom.current().nextInt();
        } else if (type.equals(double.class)) {
            return ThreadLocalRandom.current().nextDouble();
        } else if (type.equals(float.class)) {
            return ThreadLocalRandom.current().nextFloat();
        } else if (type.equals(boolean.class)) {
            return ThreadLocalRandom.current().nextBoolean();
        } else if (type.equals(byte.class)) {
            return (byte) ThreadLocalRandom.current().nextInt();
        } else if (type.equals(char.class)) {
            return (char) ThreadLocalRandom.current().nextInt(Character.MIN_VALUE, Character.MAX_VALUE);
        } else if (type.equals(String.class)) {
            return "String";
        }
        Constructor<?> constructor = Class.forName(type.getTypeName()).getConstructors()[0];
        int constructorArgsCount = constructor.getParameterCount();
        if (constructorArgsCount > 0) {
            Object[] constructorArgs = new Object[constructorArgsCount];
            Type[] types = constructor.getParameterTypes();
            for (int i = 0; i < constructorArgsCount; i++) {
                constructorArgs[i] = newClassInst(types[i]);
            }
            return constructor.newInstance(constructorArgs);
        }
        return constructor.newInstance();
    }
}
