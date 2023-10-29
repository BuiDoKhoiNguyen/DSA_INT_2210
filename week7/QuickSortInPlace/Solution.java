package week7.QuickSortInPlace;

import java.io.*;
import java.util.*;

public class Solution {
    public static int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low-1;
        
        for(int j = low ; j <= high; j++) {
            if(a[j] <= pivot) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp; 
            }    
        }
        return i;
    }
    
    public static void quickSort(int[] a, int low, int high) {
        if (high <= low) return; 
        int p = partition(a, low, high);
 
        for (int x : a) System.out.print(x + " ");
        System.out.println();

        quickSort(a, low, p - 1);
        quickSort(a, p + 1, high);
    }
 
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        } 
        quickSort(arr,0,n-1);
    }
}
