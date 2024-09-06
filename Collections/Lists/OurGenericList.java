package Collections.Lists;

public class OurGenericList<T> {
    private T[] items;
    int size;
    public OurGenericList(){
        items = (T[])new Object[100];
        size = 0;
    }
    public void add(T item){
        items[size++]=item;
    }
    public T getItemAtIndex(int indx){
        return items[indx];
    }
    public int getLength(){
        return items.length;
    }
}
