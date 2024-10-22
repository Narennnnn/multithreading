package javaBasics;
class Demo{
    Demo(){
        System.out.println("Object Created!");
    }
    public void show(){
        System.out.println("Hey from method!");
    }
}
public class anynomousObject {
    public static void main(String[] args) {
        new Demo();// anynomous object has no reference and can't be reused
        new Demo().show();
    }
}
