package lab2;

public class ClassWithAnnotation {
    @MyAnnotation()
    public void publicMethod1(int a, int b) {
        System.out.println("publicMethod1: " + a + " " + b);
    }

    @MyAnnotation(numberOfCalls = 3)
    public void publicMethod2(int a, int b) {
        System.out.println("publicMethod2: " + a + " " + b);
    }

    @MyAnnotation(numberOfCalls = 6)
    public void publicMethod3(int a, int b) {
        System.out.println("publicMethod3: " + a + " " + b);
    }

    @MyAnnotation
    private void privateMethod1(int a, int b) {
        System.out.println("privateMethod1: " + a + " " + b);
    }
    @MyAnnotation(numberOfCalls = 3)
    private void privateMethod2(int a, int b) {
        System.out.println("privateMethod2: " + a + " " + b);
    }

    @MyAnnotation()
    private void privateMethod3(int a, int b) {
        System.out.println("privateMethod3: " + a + " " + b);
    }

    @MyAnnotation(numberOfCalls = 3)
    protected void protectedMethod1(int a, int b){
        System.out.println("protectedMethod1: " + a + " " + b);
    }

    @MyAnnotation(numberOfCalls = 3)
    protected void protectedMethod2(int a, int b){
        System.out.println("protectedMethod2: " + a + " " + b);
    }

    @MyAnnotation(numberOfCalls = 2)
    protected void protectedMethod3(int a, int b){
        System.out.println("protectedMethod3: " + a + " " + b);
    }
}
