package javaBasics;
class A{
    int age;
    public void show(){
        System.out.println("In A" );
    }
    class B{
        int dob;
        public void placeOfBirth(){
            System.out.println("Dehradun");
        }
    }
}
public class InnerClasses {
    public static void main(String[] args) {
        A obj = new A();
        obj.show();
        // obj.placeOfBirth();???
        A.B obj1 = obj.new B();
        obj1.placeOfBirth(); 
    }
    
}