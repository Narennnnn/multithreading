package JavaUpdates;

import java.util.*;
public class switchCases {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String month = sc.nextLine();
        // switch without break statement
        switch (month) {
            case "Jan","Feb","March" -> System.out.println("This is not your birthday month:(");
            case "April" -> System.out.println("Happy Birthday!!");
            case "October","Novemeber","December" -> System.out.println("You will experience success in this month!");
            default -> System.out.println("enter valid month"); 
        }
        // switch as expression
        int expression = 0;
        expression = switch (month) {
            case "Jan","Feb","March" ->  100 * 11 + 2-1;
            case "April" ->  101;
            case "October","Novemeber","December" -> 99;
            default -> 404; 
        };
        /* if not using -> 
        int expression = 0;
        expression = switch (month) {
            case "Jan","Feb","March" : yield  100 * 11 + 2-1;
            case "April" : yield  101;
            case "October","Novemeber","December" : yield 99;
            default: yield 404; 
        };
        */
        System.out.println("expression got is: "+expression);
    }
}
