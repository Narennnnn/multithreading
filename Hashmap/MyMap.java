package Hashmap;
import java.util.ArrayList;
import java.util.List;
public class MyMap <K,V>{
    private List<MapNode<K,V>> bucket;// array of linked list where each index points to a linked list
    private int capacity;// size of the bucket
    private int size;//number of elements in hashmap
    private final int INITIAL_CAPACITY=5;
    public MyMap(){
        bucket = new ArrayList<>();
        capacity = INITIAL_CAPACITY;
        for(int i=0;i<capacity;i++){
            bucket.add(null);
        }
    }
    private int getBucketIndex(K key){
        int hashCode = key.hashCode();// hashCode() is a method of Object Class
        return hashCode % capacity;
    }
    public V get(K key){
        int bucketIndex = getBucketIndex(key);
        MapNode<K,V> head = bucket.get(bucketIndex);
        while(head != null){
            if(head.key.equals(key)){
                return head.value;
            }
            head=head.next;
        }
        return null;//not found
    }
    public void put(K key, V value){
        int bucketIndex = getBucketIndex(key);
        MapNode<K,V> head = bucket.get(bucketIndex);
        while(head != null){
            if(head.key.equals(key)){
                head.value = value;// if key already exists then update the value
                return;
            }
            head=head.next;
        }     
        size++;
        MapNode<K,V> newEntry = new MapNode<K,V>(key,value);
        head = bucket.get(bucketIndex);
        newEntry.next = head;
        bucket.set(bucketIndex,newEntry);
    }
    public void remove(K key){
        int bucketIndex = getBucketIndex(key);
        MapNode<K,V> head = bucket.get(bucketIndex);
        MapNode<K,V> prev = null;
        // find the node in the linked list which you want to delete: boils down to delete node from linked list
        while(head != null){
            if(head.key.equals(key)){
                if(prev == null){
                    bucket.set(bucketIndex, head.next);
                }else{
                    prev.next = head.next;
                }
                head.next = null;
                size --;
                break;
            }
            prev = head;
            head = head.next;
        } 
    }
    private class MapNode<K,V>{
        K key;
        V value;
        MapNode<K,V> next;
        public MapNode(K key, V value){
            this.key= key;
            this.value=value;
        }
    }
}
