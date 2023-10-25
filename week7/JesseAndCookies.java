
package week7;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class PriorityQueue<Key extends Comparable<Key>> {
    private Key[] pq;
    private int n;

    public PriorityQueue(int capacity) {
        pq = (Key[]) new Comparable[capacity + 1];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(Key key) {
        pq[++n] = key;
        swim(n);
    }

    public Key remove() {
        Key max = pq[1];
        exch(1, n--);
        pq[n + 1] = null;
        sink(1);
        return max;
    }

    public void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    public void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    public Key peek() {
        return pq[1];
    }   

     public int size() {
        return n;
    }
    
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
}

class Result {

    /*
     * Complete the 'cookies' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     */

    public static int cookies(int k, List<Integer> A) {
    // Write your code here
        int N = A.size();
        PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>(N);
         
        for (int i = 0; i < N; i++) {
            pqueue.insert(A.get(i));
        }
        
        int ans = 0;
        while (pqueue.size()>1) {
            Integer temp1 = pqueue.remove();
            Integer temp2 = pqueue.remove();

            if (temp1 >= k) {
                return ans;
            }

            Integer temp3 = temp1 + 2 * temp2;
            pqueue.insert(temp3);
            ans++;
        }

        return (pqueue.peek() >= k) ? ans : -1;
    }

}

public class JesseAndCookies {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
