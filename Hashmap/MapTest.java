package Hashmap;

public class MapTest {
    public static void main(String[] args) {
        MyMap<Integer, String> mp = new MyMap<>();
        mp.put(1, "abc");
        mp.put(2, "prem");
        mp.put(3, "hey");
        mp.put(4, "hashmap");
        System.out.println(mp.get(4));
        System.out.println(mp.get(10));// should get null
        mp.remove(2);
        System.out.println(mp.get(2));
    }
}