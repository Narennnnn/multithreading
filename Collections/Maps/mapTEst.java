package Collections.Maps;
import java.util.*;
public class mapTEst {
    public static void main(String[] args) {
        Map<String,Integer> mp = new HashMap<>();
        mp.put("age",21);
        mp.put("id",21021523);
        // System.out.println(mp.get("yoe"));// HashMap class is not thread safe and we might get into an exception while accessing key-value pair which doesn't exists in the map.
        // better use getOrDefault()
         System.out.println(mp.getOrDefault("id", 100));// here we can pass on default value which won't cause null pointer exception
         // also first check using containKey()
        if(mp.containsKey("yoe")){
            System.out.println(mp.get("yoe"));
        }else{
            System.out.println("Key-value pair dooesn't exists in the map!");
        }
        mp.put("yoe",2);
        mp.remove("age");

        // When dealing with Graph based quetions
        // We generally create 
        Map<Integer,List<Integer>> adj =  new HashMap<>();
        // this is right way to create adjacency list
        if(adj.get(1) == null) // where key can be any node like 1,2,3, e.g. 1
         adj.put(1, new ArrayList<>());
        adj.get(1).add(10);
        adj.get(1).add(20);
        System.out.println(adj.get(1));
        // replacement of above 5 lines
        adj.computeIfAbsent(1, f -> new ArrayList<>()).add(100);
        System.out.println(adj.get(1));
        adj.computeIfAbsent(2, f -> new ArrayList<>()).add(1001);
        System.out.println(adj.get(2));


        // Since map doesn't extends Iterable interface, map is not iterable
        // We can convert map to set (collection(iterable)) so that iteration made easy
        // 1st way
        Set<Map.Entry<String,Integer>> entrySet = mp.entrySet();
        for(Map.Entry<String,Integer> entry: entrySet){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        // 2nd Way
        Set<String> keySet = mp.keySet();
        for(String key: keySet){
            System.out.println(key+" "+mp.get(key));
        }

        // Similar to HashMap , LinkedHashMap maintains ordering but taks logN time over HahsMap's constant time
        // SortedMap sorts the key according to the order you are mentioning(generally increasing order)
    }
}
