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
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

   public static List<Integer> closestNumbers(List<Integer> arr) {
        mergeSort(arr, 0, arr.size() - 1);
        int minDiff = Integer.MAX_VALUE;
        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i < arr.size(); i++) {
            int diff = arr.get(i) - arr.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
                ans.clear();
                ans.add(arr.get(i - 1));
                ans.add(arr.get(i));
            } else if (diff == minDiff) {
                ans.add(arr.get(i - 1));
                ans.add(arr.get(i));
            }
        }

        return ans;
    }

    public static void mergeSort(List<Integer> arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            List<Integer> leftSublist = arr.subList(left, mid + 1);
            List<Integer> rightSublist = arr.subList(mid + 1, right + 1);
            mergeSort(leftSublist, 0, leftSublist.size() - 1);
            mergeSort(rightSublist, 0, rightSublist.size() - 1);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(List<Integer> arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        List<Integer> leftArr = new ArrayList<>(arr.subList(left, mid + 1));
        List<Integer> rightArr = new ArrayList<>(arr.subList(mid + 1, right + 1));

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr.get(i) <= rightArr.get(j)) {
                arr.set(k, leftArr.get(i));
                i++;
            } else {
                arr.set(k, rightArr.get(j));
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr.set(k, leftArr.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            arr.set(k, rightArr.get(j));
            j++;
            k++;
        }
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

        List<Integer> result = Result.closestNumbers(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
