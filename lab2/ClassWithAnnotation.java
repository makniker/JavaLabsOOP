package lab2;

public class ClassWithAnnotation {
    public void publicMethod1() {
        System.out.println("publicMethod1");
    }

    @MyAnnotation
    public void publicMethod2() {
        System.out.println("publicMethod2");
    }

    @MyAnnotation(numberOfCalls = 3)
    public void publicMethod3() {
        System.out.println("publicMethod3");
    }

    private void privateMethod1() {
        System.out.println("privateMethod1");
    }
    @MyAnnotation
    private void privateMethod2() {
        System.out.println("privateMethod2");
    }

    @MyAnnotation(numberOfCalls = 4)
    private void privateMethod3() {
        System.out.println("privateMethod3");
    }

    protected void protectedMethod1(){
        System.out.println("protectedMethod1");
    }

    @MyAnnotation
    protected void protectedMethod2(){
        System.out.println("protectedMethod2");
    }

    @MyAnnotation(numberOfCalls = 2)
    protected void protectedMethod3(){
        System.out.println("protectedMethod3");
    }
}
