package javaBasics;
class Demo{
    // instance variable are assigned memory in heap whereas local variables are assisgned memory in stack
    int age;
    String name;
    static String collegName;
    // Static make sure there is only copy of that variable, static variable is common to all objects(making any change to it will reflect back in other classes too)

    static{
        collegName = "Graphic Era University";
        System.out.println("Class is loaded");
    }
    public void show(){
        // non static method can access a static instance variable
        System.out.println(age + " : "+name+" : "+collegName);
    }
    public static void show1(){
        // non static variables can not accessed in a static method
        System.out.println(collegName);
    }
}
public class staticKeyword {
    public static void main(String[] args) throws ClassNotFoundException {
        // static methods/variables needs to be accesses with class name and doesn't need object to access them
        /* 
        Demo obj = new Demo();// 1. Class is loaded in class loader 2. Objects are instantiated
        obj.age = 10;
        obj.name="Harshit";
        obj.show();
        Demo.show1();
        */
        // what is we just want to load the class?
        Class.forName("javaBasics.Demo");// loads class
    }
}
