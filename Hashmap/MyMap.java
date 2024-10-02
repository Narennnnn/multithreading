package Hashmap;
import java.util.ArrayList;
import java.util.List;

public class MyMap<K, V> {
    private List<MapNode<K, V>> bucket; // array of linked list where each index points to a linked list
    private int capacity; // size of the bucket
    private int size; // number of elements in hashmap
    private final int INITIAL_CAPACITY = 5;

    public MyMap() {
        bucket = new ArrayList<>();
        capacity = INITIAL_CAPACITY;
        for (int i = 0; i < capacity; i++) {
            bucket.add(null); // initialize bucket with null values
        }
    }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode(); // hashCode() is a method of Object class
        return hashCode % capacity;
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = bucket.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null; // not found
    }

    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = bucket.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value; // if key already exists then update the value
                return;
            }
            head = head.next;
        }
        size++;
        MapNode<K, V> newEntry = new MapNode<>(key, value);
        head = bucket.get(bucketIndex);
        newEntry.next = head; // insert new node at the beginning of the linked list
        bucket.set(bucketIndex, newEntry);
        // to handle case if load factor size/capacity > 0.75 , we need to add another bucket to accomodate more key value pairs
        double loadFactor = (1.0 * size)/capacity;
        System.out.println("Inserting key "+key);
        System.out.println("Load factor "+loadFactor);
        if(loadFactor>0.7)
         rehash();
    }
    public void rehash(){
        System.out.println("Rehashing buckets ");
        List<MapNode<K,V>> temp = bucket;
        bucket = new ArrayList<>();
        capacity = capacity*2;
        for (int i = 0; i < capacity; i++) {
            bucket.add(null); // initialize bucket with null values
        }
        size=0;
        for(int i=0;i<temp.size();i++){
            MapNode<K,V> head = temp.get(i);
            while(head != null){
                put(head.key,head.value);//rehash entire bucket
                head = head.next;
            }

        }     
    }
    public void remove(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = bucket.get(bucketIndex);
        MapNode<K, V> prev = null;
        // find the node in the linked list which you want to delete: boils down to deleting node from linked list
        while (head != null) {
            if (head.key.equals(key)) {
                if (prev == null) {
                    bucket.set(bucketIndex, head.next); // remove head node
                } else {
                    prev.next = head.next; // bypass the current node
                }
                head.next = null;
                size--;
                break;
            }
            prev = head;
            head = head.next;
        }
    }

    private class MapNode<K, V> {
        K key;
        V value;
        MapNode<K, V> next;

        public MapNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
// refer : https://www.youtube.com/watch?v=sHpjxXX81Gw&t=1100s
// special thanks to Riddhi Sir!