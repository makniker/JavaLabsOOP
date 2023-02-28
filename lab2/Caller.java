package lab2;

public class Caller {
    private ClassWithAnnotation classWithAnnotation = new ClassWithAnnotation();
    public void call(){
        classWithAnnotation.protectedMethod1();
    }
}
