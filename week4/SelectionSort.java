package week4;

import java.util.Scanner;

import edu.princeton.cs.algs4.*;


public class SelectionSort{
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }  
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        Stopwatch timer = new Stopwatch();
        selectionSort(arr);
        StdOut.println("elapsed time = " + timer.elapsedTime());
        for(int x:arr){
            System.out.print(x + " ");
        }
    }
}