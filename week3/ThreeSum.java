package week3;

import edu.princeton.cs.algs4.*;

public class ThreeSum {

    private ThreeSum() { }

    public static int printAll(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        StdOut.println(a[i] + " " + a[j] + " " + a[k]);
                        count++;

                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args)  {
        In in = new In("C:\\Users\\nguye\\IdeaProjects\\algs4\\algs4-data\\1Kints.txt");
        int[] a = in.readAllInts();

        Stopwatch timer = new Stopwatch();
        int count = printAll(a);
        StdOut.println("elapsed time = " + timer.elapsedTime());
        StdOut.println(count);
    }
}