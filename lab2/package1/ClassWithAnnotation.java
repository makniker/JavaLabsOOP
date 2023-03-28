package lab2.package1;

import lab2.package2.CustomClass;

public class ClassWithAnnotation {
    @MyAnnotation
    private void privateMethod(int a, double b, float c) {
        System.out.println(a + " " + b + " " + c);
    }
    @MyAnnotation(numberOfCalls = 3)
    private void privateMethod(int a, float b, char c) {
        System.out.println(a + " " + b + " " + c);
    }
    @MyAnnotation(numberOfCalls = 1)
    private void privateMethod(String a, String b, String c) {
        System.out.println(a + " " + b + " " + c);
    }
    @MyAnnotation(numberOfCalls = 1)
    private void privateMethod(String a, CustomClass b, String c) {
        System.out.println(a + " " + " " + c);
        System.out.println("Custom class!");
    }
    @MyAnnotation
    protected void protectedMethod(int a, double b, float c) {
        System.out.println(a + " " + b + " " + c);
    }
    @MyAnnotation(numberOfCalls = 3)
    protected void protectedMethod(int a, float b, char c) {
        System.out.println(a + " " + b + " " + c);
    }
    @MyAnnotation(numberOfCalls = 1)
    protected void protectedMethod(String a, String b, String c) {
        System.out.println(a + " " + b + " " + c);
    }
    @MyAnnotation
    public void publicMethod(int a, double b, float c) {
        System.out.println(a + " " + b + " " + c);
    }
    @MyAnnotation(numberOfCalls = 3)
    public void publicMethod(int a, float b, char c) {
        System.out.println(a + " " + b + " " + c);
    }
    @MyAnnotation(numberOfCalls = 1)
    public void publicMethod(String a, String b, String c) {
        System.out.println(a + " " + b + " " + c);
    }
}
