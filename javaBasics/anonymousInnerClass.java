package javaBasics;
class A{
    public void show(){
        System.out.println("In class A");
    }
}
public class anonymousInnerClass {
    public static void main(String[] args) {
        // What if we want to change the meaning of show method of class A only once
        // instead of overriding it in diffrent class, we can simply create an anonymous clas

        A obj = new A(){
            public void show(){
                System.out.println("In anonymous class");
            }
        };
        obj.show();

    }
}
