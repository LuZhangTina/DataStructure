/**
 * Created by tina on 2019/1/17.
 */
public class LinkedQueue<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;
    private int capacity;
    private final static int DEFAULT_CAPACITY = 10;
    private static class Node<E> {
        E iteam;
        Node<E> next;

        Node(E iteam, Node<E> next) {
            this.iteam = iteam;
            this.next = next;
        }
    }
    public LinkedQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.capacity = DEFAULT_CAPACITY;
    }
    public LinkedQueue(int capacity) {
        this();
        if (capacity > 0) {
            this.capacity = capacity;
        }
    }

    public boolean enqueue(E iteam){
        if (size == capacity) {
            return false;
        }

        Node<E> node = new Node<E>(iteam, null);
        if (head == null) {
            head = node;
        }

        if (tail != null) {
            tail.next = node;
        }
        tail = node;
        size++;
        return true;
    }

    public E dequeue() {
        if (size == 0) {
            return null;
        }

        Node<E> node = head;
        head = head.next;
        size--;
	if (head == null) {
	    tail = null;
	}

        return node.iteam;
    }

    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.capacity;
    }
}
