package javaBasics;
@FunctionalInterface
/**
 * InnerlambdaGame
 */
interface InnerlambdaGame {
    // SAM: Single Abstract Method
    void show();// interface having only one public and abstract method is called Functional interface    
}
public class lambdaGame {
    public static void main(String[] args) {
        /* 
        InnerlambdaGame obj = new InnerlambdaGame() {
            public void show(){
            // do blah blah!
            }


            // Anonymous class way
            // Java 8 brought new feature of Lambda expressions which works only on functional interface

        };
        */
        InnerlambdaGame obj = ()->{
            System.out.println("In show method!");
        };
        obj.show();
    }
}
