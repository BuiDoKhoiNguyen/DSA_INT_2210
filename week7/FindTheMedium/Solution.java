package week7.FindTheMedium;

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

class Result {

    /*
     * Complete the 'findMedian' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
     public static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(high);
        int i=low-1;
        
        for(int j=low; j <= high; j++) {
            if(arr.get(j) <= pivot) {
                i++;
                Integer temp = arr.get(i);
                arr.set(i ,arr.get(j));
                arr.set(j, temp);
            }
        }
        return i;
    }
    
    public static int findMedian(List<Integer> arr) {
    // Write your code here
        int n = arr.size();
        int k = n / 2; 
        int low = 0;
        int high = n - 1;
        
        while (low < high) {
            int p = partition(arr, low, high);
            
            if (p == k) {
                return arr.get(p);
            } else if (p < k) {
                low = p + 1;
            } else {
                high = p - 1;
            }
        }
        
        return arr.get(low);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.findMedian(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

