package week3;

import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class ThreeSumFastest {
    public static int printAll(int[] a) {
        int n = a.length;
        Arrays.sort(a);
        int count = 0;
        //if (containsDuplicates(a)) throw new IllegalArgumentException("array contains duplicate integers");
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            int x = a[i];
            while (left < right) {
                int sum = x + a[left] + a[right];
                if (sum == 0) {
                    StdOut.println(x + " " + a[left] + " " + a[right]);
                    count++;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }



    private static boolean containsDuplicates(int[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i] == a[i-1]) return true;
        return false;
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
