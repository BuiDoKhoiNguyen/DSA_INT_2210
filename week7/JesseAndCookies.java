package week7;


class PriorityQueue<Key extends Comparable<Key>>{
    private Key[] pq;
    private int n;

    public PriorityQueue(int capacity) {
        pq = (Key[]) new Comparable[capacity+1]; 
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(Key key) {

    }

    public Key delMax() {

    }

    public void swim(int k) {

    }

    public void sink(int k) {

    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j] < 0);
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
}
public class JesseAndCookies {
    // PriorityQueue<Integer> pqueue = new PriorityQueue<>(A); 
}
