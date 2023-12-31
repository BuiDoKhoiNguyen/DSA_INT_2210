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

class priorityQueue {
                
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
        PriorityQueue<Integer> pqueue = new PriorityQueue<>(N);
         
        for (int i = 0; i < N; i++) {
            pqueue.add(A.get(i));
        }
        
        int ans = 0;
        while (pqueue.size()>1) {
            Integer temp1 = pqueue.remove();
            Integer temp2 = pqueue.remove();

            if (temp1 >= k) {
                return ans;
            }

            Integer temp3 = temp1 + 2 * temp2;
            pqueue.add(temp3);
            ans++;
        }

        return (pqueue.peek() >= k) ? ans : -1;
    }

}

public class Solution {
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
