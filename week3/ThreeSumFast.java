package week3;

import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class ThreeSumFast {

    public static int printAll(int[] a) {
        int n = a.length;
        Arrays.sort(a);
        int count = 0;
        //if (containsDuplicates(a)) throw new IllegalArgumentException("array contains duplicate integers");
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int k = Arrays.binarySearch(a, -(a[i] + a[j]));
                if (k > j){
                    StdOut.println(a[i] + " " + a[j] + " " + a[k]);
                    count++;
                } 
            }
        }
        return count;
    }


    public static void main(String []args) {
        In in = new In("C:\\Users\\nguye\\IdeaProjects\\algs4\\algs4-data\\1Kints.txt");
        int[] a = in.readAllInts();
        Stopwatch timer = new Stopwatch();
        int count = printAll(a);
    
        StdOut.println("elapsed time = " + timer.elapsedTime());
        StdOut.println(count);
    }
}
