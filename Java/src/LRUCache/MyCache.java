import java.util.LinkedList;

/**
 * Created by tina on 2019/1/16.
 */
public class MyCache<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private LinkedList<E> doublelist;

    public MyCache(int capacity) {
        if (capacity <= 0 || capacity > Integer.MAX_VALUE) {
            this.capacity = DEFAULT_CAPACITY;
        }else {
            this.capacity = capacity;
        }
        this.doublelist = new LinkedList<E>();
    }

    public void add(E obj) {
        if(doublelist.contains(obj)) {
            doublelist.remove(obj);
            doublelist.addFirst(obj);
        }else{
            if (doublelist.size() < capacity) {
                doublelist.addFirst(obj);
            }else{
                doublelist.removeLast();
                doublelist.addFirst(obj);
            }
        }
    }

    public E getFirst() {
        return doublelist.getFirst();
    }

    public E get(int index) {
        if (index < 0 || index >= capacity) {
            return null;
        }
        return doublelist.get(index);
    }

    public int size() {
        return doublelist.size();
    }

    public int getCapacity() {
        return this.capacity;
    }
}
