package week12;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'shortestReach' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     * 1. INTEGER n
     * 2. 2D_INTEGER_ARRAY edges
     * 3. INTEGER s
     */


    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
        // Write your code here
        List<Integer> dist = new ArrayList<>(Collections.nCopies(n + 1, -1));
        dist.set(s, 0);

        Set<List<Integer>> edgeSet = new HashSet<>(edges);
        List<List<Integer>> uniqueEdges = new ArrayList<>(edgeSet);

        boolean[] visited = new boolean[n + 1];

        while (true) {
            int node = 0;
            int nodeValue = -1;
            for (int i = 1; i < n + 1; i++) {
                if (!visited[i] && dist.get(i) != -1 && (nodeValue == -1 || dist.get(i) < nodeValue)) {
                    node = i;
                    nodeValue = dist.get(i);
                }
            }
            if (node == 0)
                break;
            visited[node] = true;

            for (List<Integer> it : uniqueEdges) {
                if (!it.get(0).equals(node) && !it.get(1).equals(node))
                    continue;

                int targetNode = it.get(0).equals(node) ? it.get(1) : it.get(0);
                if (visited[targetNode])
                    continue;
                if (dist.get(targetNode) == -1 || (dist.get(node) + it.get(2)) < dist.get(targetNode)) {
                    dist.set(targetNode, dist.get(node) + it.get(2));
                }
            }
        }
        dist.remove(s);
        dist.remove(0);
        return dist;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            int m = Integer.parseInt(firstMultipleInput[1]);

            List<List<Integer>> edges = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                String[] edgesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                List<Integer> edgesRowItems = new ArrayList<>();

                for (int j = 0; j < 3; j++) {
                    int edgesItem = Integer.parseInt(edgesRowTempItems[j]);
                    edgesRowItems.add(edgesItem);
                }

                edges.add(edgesRowItems);
            }

            int s = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> result = Result.shortestReach(n, edges, s);

            for (int i = 0; i < result.size(); i++) {
                bufferedWriter.write(String.valueOf(result.get(i)));

                if (i != result.size() - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
