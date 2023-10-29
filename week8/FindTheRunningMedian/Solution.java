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
import java.util.PriorityQueue;

class Result {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Double> runningMedian(List<Integer> a) {
    // Write your code here
        Queue<Integer> minPQ = new PriorityQueue<Integer>();
        Queue<Integer> maxPQ = new PriorityQueue<Integer>(Comparator.reverseOrder());

        List<Double> keys = new ArrayList<Double>();
        keys.add(a.get(0) * 1.0);
        maxPQ.add(a.get(0));

        for (int i = 1; i < a.size(); i++) {
            int number = a.get(i);

            if (number > maxPQ.peek()) minPQ.add(number);
            else maxPQ.add(number);

            if (minPQ.size() - maxPQ.size() > 1) maxPQ.add(minPQ.poll());
            else if (maxPQ.size() - minPQ.size() > 1) minPQ.add(maxPQ.poll());

            if (i % 2 == 0) {
                if (maxPQ.size() > minPQ.size()) keys.add(maxPQ.peek() * 1.0);
                else keys.add(minPQ.peek() * 1.0);
            } else keys.add((maxPQ.peek() + minPQ.peek()) * 0.5);
        }
        return keys;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Double> result = Result.runningMedian(a);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
