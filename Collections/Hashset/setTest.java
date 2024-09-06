package Collections.Hashset;
import java.util.*;
public class setTest {
    public static void main(String[] args) {
        Set<Integer> uSet = new HashSet<>();
        for(int i=0;i<10;i++){
            if(i%2==0){
                uSet.add(i*2+1);
            }
        }
        System.out.println(uSet.size());
        // while(itr.hasNext()){
        //     System.out.print(itr.next()+" ");
        // }
        uSet.remove(13);
        Iterator<Integer> itr = uSet.iterator();
        System.out.println();
        while(itr.hasNext()){
            System.out.print(itr.next()+" ");
        }
        System.out.println();
        if(uSet.contains(5)){
            System.out.println("Hashset contains 5!");
        }
        uSet.clear();// empties
        Iterator<Integer> itr2 = uSet.iterator();
        System.out.println();
        while(itr2.hasNext()){
            System.out.println("couldn't clear");
            System.out.print(itr2.next()+" ");
        }
        List<String> cities = new ArrayList<>();
        cities.add("Dehradun");
        cities.add("Bangalore");
        cities.add("Hyderabad");
        cities.add("Dehradun");
        System.out.println();
        for(String city: cities)
         System.out.print(city+" ");
        Set<String> uniqueCity = new HashSet<>(cities);
        System.out.println();
        for(String city: uniqueCity)
         System.out.print(city+" ");
    }
}

/*
    Internally HashSet uses HashMap
    private transient HashMap map;

    // Constructor - 1
    // All the constructors are internally creating HashMap Object.
    public HashSet()
    {
        // Creating internally backing HashMap object
        map = new HashMap();
    }

    // Constructor - 2
    public HashSet(int initialCapacity)
    {
        // Creating internally backing HashMap object
        map = new HashMap(initialCapacity);
    }

    // Dummy value to associate with an Object in Map
    private static final Object PRESENT = new Object();

*/
