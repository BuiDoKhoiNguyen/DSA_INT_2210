import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        int []a = new int[n];
        
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        
        if(n <= k) {
            for(int i = 0; i < n; i++) {
                sum+=a[i];
                System.out.print(sum + " ");
            }
        } 
        else {
            for(int i = 0; i < n; i++) {
                sum += a[i];
                pq.add(a[i]);
                while(pq.size() > k) {
                    sum -= pq.poll();
                }
                System.out.print(sum + " ");
            }
        }
        
    }
}