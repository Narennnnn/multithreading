package Collections.Lists;

import java.util.*;

public class ArryaLists {
    public static void main(String[] args) {
        // OurGenericList<Integer> list = new OurGenericList<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(i*10+1);
        }
        // System.out.println(list.getItemAtIndex(8));
        System.out.println(list);
        // to replace any value at any index
        list.set(1, 22);
        System.out.println(list);
        List<Integer> copyList = new ArrayList<>(list);// since collections can be passed to constructor
        System.out.println(copyList);
        copyList.addAll(list);
        System.out.println(copyList);
        System.out.println(copyList.indexOf(51));
        List<Integer> temp = copyList.subList(1, 8);// unlike constructor sublist() function acts as reference and make changes in the  original list as well
        System.out.println(temp);

        Integer[] arr = temp.toArray(new Integer[0]);// we can pass array of any size as parameter to convert list to array
        for(int a:arr){
            System.out.print(a+", ");
        }
    }
}
