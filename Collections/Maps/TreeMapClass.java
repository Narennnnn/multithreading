package Collections.Maps;

import java.util.*;

public class TreeMapClass {
    public static void main(String[] args) {
        // TreeMap class implements NavigableMap interface
        // uses balanced trees
        // very similar to navigable set functions
        NavigableMap<Integer, String> tmap =  new TreeMap<>();// to sort keys in reverse order pass comparator (a,b)->b-a
        tmap.put(1,"riddhi");
        tmap.put(2, "harsh");
        tmap.put(3,"jay");
        System.out.println(tmap);
        Set<Integer> keySet = tmap.keySet();
        for(Integer key: keySet){
            System.out.println(key+" "+tmap.get(key));
        }

    }   
    
}
// TC:O(logn)
